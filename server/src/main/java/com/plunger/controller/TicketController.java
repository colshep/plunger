package com.plunger.controller;

import java.util.Arrays;

public class TicketController {

    public static void main(String[] args) {
        String[] result = "07 10 12 16 19 31 16".split(" ");
        String[] list = ("02 03 13 15 17 21 02\n" +
                "02 03 13 15 17 21 03\n" +
                "03 04 10 15 21 24 03\n" +
                "05 06 15 30 31 33 03\n" +
                "12 13 14 16 28 29 05\n" +
                "08 09 10 18 32 33 06\n" +
                "07 18 20 21 22 25 08\n" +
                "02 17 18 21 28 29 09\n" +
                "04 07 20 25 26 29 09\n" +
                "02 14 20 23 32 33 10\n" +
                "08 11 15 23 24 27 11\n" +
                "01 04 06 10 17 23 12\n" +
                "07 13 14 21 29 30 12\n" +
//                "01 03 18 20 28 29 14\n" +
//                "06 13 18 19 21 22 14\n" +
//                "07 18 20 23 27 29 14\n" +
//                "11 14 15 24 31 32 14\n" +
//                "11 18 24 28 30 32 14\n" +
//                "16 21 25 28 29 31 14\n" +
//                "17 18 20 23 27 29 14\n" +
                "06 08 11 15 20 25 15").split("\n");

        int rewardSum = 0;
        System.out.println("开奖号码：" + Arrays.asList(result));
        for (String str : list) {
            String[] arr = str.split(" ");
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
             *
             * 一等奖：当奖池资金低于1亿元时，奖金总额为当期高奖级奖金的75%与奖池中累积的资金之和，单注奖金按注均分，单注最高限额封顶500万元。
             * 当奖池资金高于1亿元（含）时，奖金总额包括两部分，一部分为当期高奖级奖金的55%与奖池中累积的资金之和，单注奖金按注均分，
             * 单注最高限额封顶500万元；另一部分为当期高奖级奖金的20%，单注奖金按注均分，单注最高限额封顶500万元。
             * 二等奖：奖金总额为当期高奖级奖金的25%，单注奖金按注均分，单注最高限额封顶500万元。
             * 三等奖：单注奖金固定为3000元。
             * 四等奖：单注奖金固定为200元。
             * 五等奖：单注奖金固定为10元。
             * 六等奖：单注奖金固定为5元。
             */
            int mult = 2;
            if (countRed == 6 & countBlue) {
                p = "一等奖";
                reward = 5000000 * mult;
            } else if (countRed == 6) {
                p = "二等奖";
                reward = 5000000 * mult;
            } else if (countRed == 5 && countBlue) {
                p = "三等奖";
                reward = 3000 * mult;
            } else if (countRed == 5 || (countRed == 4 && countBlue)) {
                p = "四等奖";
                reward = 200 * mult;
            } else if (countRed == 4 || (countRed == 3 && countBlue)) {
                p = "五等奖";
                reward = 10 * mult;
            } else if (countBlue) {
                p = "六等奖";
                reward = 5 * mult;
            }
            rewardSum += reward;

            System.out.println(Arrays.asList(arr) + "，红球数量：" + countRed + "，蓝球数量：" + (countBlue ? 1 : 0) + "，" + p + "，奖金：" + reward);
        }
        System.out.println("总奖金：" + rewardSum);

    }
}
