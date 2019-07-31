package com.dl.comm.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.dl.comm.config.Constant;

import java.io.File;

/**
 * OSS工具类
 */
public class OSSUtil {

    /** 过期时间(10年) */
    private static final int CACHE_CONTROL_EXPIRE = 10 * 365 * 24 * 60 * 60;

    /**
     * 文件上传到oss
     *
     * @param oosPath - oos文件路径
     * @param file
     */
    public static final void fileUpload(String oosPath, File file) {
        OSS ossClient = new OSSClientBuilder().build(Constant.OSS.ENDPOINT, Constant.OSS.ACCESSKEY, Constant.OSS.ACCESSKEY_SECRET);// 创建OSSClient实例
        try {
            ObjectMetadata meta = new ObjectMetadata();
            meta.setCacheControl("public, max-age=" + CACHE_CONTROL_EXPIRE);
            ossClient.putObject(Constant.OSS.BUCKET_NAME, oosPath, file);
        } finally {
            ossClient.shutdown();// 关闭OSSClient
        }

    }


}
