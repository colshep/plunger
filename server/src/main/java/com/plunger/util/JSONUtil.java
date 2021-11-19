package com.plunger.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JSONUtil {

    /**
     * 根据class去除不存在的属性
     *
     * @param jsonObject
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> JSONObject removeInvalidProperties(JSONObject jsonObject, Class<T> clazz) {
        JSONObject copy = JSONObject.fromObject(jsonObject.toString());
        Field[] fields = clazz.getDeclaredFields();
        copy.keySet().forEach((key) -> {
            boolean isValid = false;
            for (Field field : fields) {
                if (field.getName().equals(key)) {
                    isValid = true;
                    break;
                }
            }
            if (!isValid) {
                jsonObject.remove(key);
            }
        });
        return jsonObject;
    }

    public static <T> JSONArray removeInvalidProperties(JSONArray jsonArray, Class<T> clazz) {
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonArray.set(i, removeInvalidProperties(jsonArray.getJSONObject(i), clazz));
        }
        return jsonArray;
    }

    public static <T> T toBeanIgnoreInvalidProperties(JSONObject jsonObject, Class<T> clazz) {
        return (T) JSONObject.toBean(removeInvalidProperties(jsonObject, clazz), clazz);
    }

    public static <T> List<T> toBeanListIgnoreInvalidProperties(JSONArray jsonArray, Class<T> clazz) {
        List<T> returnList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            returnList.add(toBeanIgnoreInvalidProperties(obj, clazz));
        }
        return returnList;
    }
}
