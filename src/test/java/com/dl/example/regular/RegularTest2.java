package com.dl.example.regular;

import org.junit.Test;

/**
 * 正则练习2
 */
public class RegularTest2 {

    /** 连续3个数字 */
    @Test
    public void test1() {
        String num = "s112s";
        boolean matches = num.matches(".*\\d{3}.*");
        System.out.println(matches);
    }

    /** 连续2个相同的 数字 */
    @Test
    public void test2() {
        String num = "s223s";
        boolean matches = num.matches(".*(\\d)\\1.*");
        System.out.println(matches);
    }

    /** 连续3个相同的 数字 */
    @Test
    public void test3() {
        String num = "s2223s";
        boolean matches = num.matches(".*(\\d)\\1{2}.*");
        System.out.println(matches);
    }

    /** 正整数 */
    @Test
    public void test4() {
        String num = "134";
        System.out.println(num.matches("[1-9]\\d*"));
    }

    /** 负整数 */
    @Test
    public void test5() {
        String num = "-1";
        System.out.println(num.matches("-[1-9]\\d*"));
    }

    /** 整数 */
    @Test
    public void test6() {
        String num = "234";
        System.out.println(num.matches("-?\\d+"));
    }

    //

    /** 正浮点数 */
    @Test
    public void test7() {
        String num = "1232.232";
        System.out.println(num.matches("\\d+\\.\\d+"));
    }
    //负浮点数
    //浮点数
    //中文字符
    //空格
    //换行
}
