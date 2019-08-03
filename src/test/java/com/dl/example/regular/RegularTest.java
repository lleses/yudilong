package com.dl.example.regular;

import org.junit.Test;

/**
 * 正则练习
 */
public class RegularTest {

    /** 11位的电话号码 */
    @Test
    public void test1() {
        String phone = "13416000672";
        boolean matches = phone.matches("1[3-9]\\d{9}");
        System.out.println(matches);
    }

    /** 包含某个字符串 */
    @Test
    public void test2() {
        String content = "abcsssscbawww";
        boolean matches = content.matches(".*cba.*");
        System.out.println(matches);
    }

    /** 匹配整数或者小数（包括正数和负数） */
    @Test
    public void test3() {
        String number = "123.565";
        boolean matches = number.matches("-?\\d+(\\.\\d+)?");
        System.out.println(matches);


    }

    /** 匹配年月日日期 格式2018-12-6 */
    @Test
    public void test4() {
        String date = "2018-10-2";
        boolean matches = date.matches("[12]\\d{3}-((1[0-2])|(0?\\d))-(0?\\d|([12]\\d)|(3[01]))");
        System.out.println(matches);
    }

    /** 长度为8-10位的用户密码 ： 包含数字字母下划线 */
    @Test
    public void test5() {
        String pwd = "didi123_";
        boolean matches = pwd.matches("\\w{8,10}");
        System.out.println(matches);
    }

    /** 匹配验证码：4位数字字母组成的 */
    @Test
    public void test6() {
        String code = "05aR";
        System.out.println(code.matches("[A-Za-z\\d]{4}"));
    }

    /** 匹配邮箱地址 */
    @Test
    public void test7() {
        String email = "840851604@qq.com";
        System.out.println(email.matches(".+@.+\\..+"));
    }

    /** 匹配中文 */
    @Test
    public void test8() {
        String name = "你好";
        System.out.println(name.matches("[\\u4E00-\\u9FA5]*"));
    }

    /**
     * 匹配时间格式：小时:分钟:秒, 24小时制
     */
    @Test
    public void test9() {
        String time = "05:16:32";
        System.out.println(time.matches("((0?\\d)|(1[0-2]))(:((0?\\d)|([1-5]\\d))){2}"));
    }


}
