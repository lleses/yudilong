package com.dl.comm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * ID工具
 */
public class IdUtil {

    /**
     * 根据当前时间生成32位ID
     *
     * @return yyyyMMddHHmmssSSS+ranNum(15)
     */
    public static String id32() {
        return secId(32);
    }


    /**
     * ID 生成 - 按时间生成,yyyyMMddHHmmssSSS(17位)+(len-17)位随机数字
     *
     * @param len
     *            长度,超过17的填充随机数字
     * @return 指定长度的数字字符串
     */
    private static String secId(int len) {
        StringBuilder id = new StringBuilder();
        id.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        int l = len - 17;
        if (l > 0) {
            id.append(ranNum(l));
            return id.toString();
        } else {
            return id.substring(0, len);
        }
    }

    /**
     * 生成随机数字字符串
     *
     * @param len
     *            字符串长度
     * @return
     */
    private static String ranNum(int len) {
        char[] ncArrs = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        int ncArrsLength = ncArrs.length;
        if (len < 1) {
            return "";
        }
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < len; i++) {
            str.append(ncArrs[new Random().nextInt(ncArrsLength)]);
        }
        return str.toString();
    }
}