package com.plunger.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketController {

    public static void main(String[] args) {
        String[] result = new String[]{"01", "04", "06", "14", "20", "28", "08" };
        List<String> list = new ArrayList<>();
        list.add("07182023272914");
        list.add("08111523242711");
        list.add("05092127283307");
        list.add("12131416282905");
        list.add("12131421293007");
        list.add("09152125282907");
        list.add("01101420233210");
        list.add("14151821273213");
        list.add("01021819263105");
        list.add("03041920253107");
        list.add("01111220283314");
        list.add("01161725303211");
        list.add("07082425283208");
        list.add("02030609202608");
        list.add("05101620213207");
        list.add("03041015212410");
        list.add("03081014212714");
        list.add("04101426273312");
        list.add("10131621253214");
        list.add("03122327283210");
        list.add("08141920233115");
        list.add("01171820323305");
        list.add("09101318252615");
        list.add("02071923273107");

        int rewardSum = 0;
        System.out.println("开奖号码：" + Arrays.asList(result));
        for (String str : list) {
            String[] arr = new String[7];
            List<String> o = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                arr[i] = str.substring(i * 2, i * 2 + 2);
                o.add(str.substring(i * 2, i * 2 + 2));
            }

            String p = "未中奖";
            int reward = 0;
            boolean countBlue = false;
            if (result[6].equals(arr[6])) {
                countBlue = true;
            }
            int countRed = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (result[j].equals(arr[i])) {
                        countRed++;
                    }
                }
            }


            /**
             * 一等奖：投注号码与当期开奖号码全部相同（顺序不限，下同），即中奖；
             * 二等奖：投注号码与当期开奖号码中的6个红色球号码相同，即中奖；
             * 三等奖：投注号码与当期开奖号码中的任意5个红色球号码和1个蓝色球号码相同，即中奖；
             * 四等奖：投注号码与当期开奖号码中的任意5个红色球号码相同，或与任意4个红色球号码和1个蓝色球号码相同，即中奖；
             * 五等奖：投注号码与当期开奖号码中的任意4个红色球号码相同，或与任意3个红色球号码和1个蓝色球号码相同，即中奖；
             * 六等奖：投注号码与当期开奖号码中的1个蓝色球号码相同，即中奖。
             */
            /**
             * 一等奖：当奖池资金低于1亿元时，奖金总额为当期高奖级奖金的75%与奖池中累积的资金之和，单注奖金按注均分，单注最高限额封顶500万元。
             * 当奖池资金高于1亿元（含）时，奖金总额包括两部分，一部分为当期高奖级奖金的55%与奖池中累积的资金之和，单注奖金按注均分，
             * 单注最高限额封顶500万元；另一部分为当期高奖级奖金的20%，单注奖金按注均分，单注最高限额封顶500万元。
             * 二等奖：奖金总额为当期高奖级奖金的25%，单注奖金按注均分，单注最高限额封顶500万元。
             * 三等奖：单注奖金固定为3000元。
             * 四等奖：单注奖金固定为200元。
             * 五等奖：单注奖金固定为10元。
             * 六等奖：单注奖金固定为5元。
             */
            if (countRed == 6 & countBlue) {
                p = "一等奖";
                reward = 5000000 * 2;
            } else if (countRed == 6) {
                p = "二等奖";
                reward = 5000000 * 2;
            } else if (countRed == 5 && countBlue) {
                p = "三等奖";
                reward = 3000 * 2;
            } else if (countRed == 5 || (countRed == 4 && countBlue)) {
                p = "四等奖";
                reward = 200 * 2;
            } else if (countRed == 4 || (countRed == 3 && countBlue)) {
                p = "五等奖";
                reward = 10 * 2;
            } else if (countBlue) {
                p = "六等奖";
                reward = 5 * 2;
            }
            rewardSum += reward;

            System.out.println(o + "，红球数量：" + countRed + "，蓝球数量：" + (countBlue ? 1 : 0) + "，" + p + "，奖金：" + reward);
        }
        System.out.println("总奖金：" + rewardSum);


    }
}
