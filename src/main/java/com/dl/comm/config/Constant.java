package com.dl.comm.config;

import com.dl.comm.utils.SpringUtil;

/**
 * 常量配置类
 */
public class Constant {

    public static final class OSS {
        public static final String ENDPOINT = getProperty("oss.endpoint");
        public static final String ACCESSKEY = getProperty("oss.accessKey");
        public static final String ACCESSKEY_SECRET = getProperty("oss.accesskeysecret");
        public static final String BUCKET_NAME = getProperty("oss.bucketname");
        public static final String BASEURL = getProperty("oss.baseurl");
    }

    protected static String getProperty(String name) {
        return SpringUtil.getApplicationContext().getEnvironment().getProperty(name);
    }

}
