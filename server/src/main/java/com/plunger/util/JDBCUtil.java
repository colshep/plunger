package com.plunger.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCUtil implements ApplicationContextAware {

    /**
     * 单例模式
     */
    private static JDBCUtil instance = new JDBCUtil();

    private JDBCUtil() {
    }

    public static JDBCUtil getInstance() {
        return instance;
    }

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (JDBCUtil.applicationContext == null) {
            // 初始化 spring applicationContext
            JDBCUtil.applicationContext = applicationContext;
        }
    }

    private static JdbcTemplate jdbcTemplate;

    public static JdbcTemplate getJdbcTemplate() {
        if (instance.jdbcTemplate == null) {
            instance.jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        }

        return instance.jdbcTemplate;
    }

    private static <T> String findDataSourceName(Class<T> clazz) {
        return "plunger";
    }

    private static JSONArray queryForJSONArray(JdbcTemplate jdbcTemplate, String sql, Object... args) {
        return JSONArray.fromObject(jdbcTemplate.queryForList(sql, args));
    }

    public static JSONArray queryForJSONArray(String sql, Object... args) {
        return queryForJSONArray(getJdbcTemplate(), sql, args);
    }

    public static <T> JSONArray queryForJSONArray(Class<T> clazz, String sql, Object... args) {
        return queryForJSONArray(findDataSourceName(clazz), sql, args);
    }

    public static <T> List<T> queryForList(Class<T> clazz, String sql, Object... args) {
        List<T> returnList = new ArrayList<>();
        JSONArray array = queryForJSONArray(clazz, sql, args);
        for (int i = 0; i < array.size(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            Object obj = JSONObject.toBean(jsonObject, clazz);
            returnList.add((T) obj);
        }
        return returnList;
    }


}
