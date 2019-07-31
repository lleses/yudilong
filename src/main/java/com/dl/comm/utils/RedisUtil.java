package com.dl.comm.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
@Component
public class RedisUtil {

    /** 默认过期时长，单位：秒 */
    public static final long DEFAULT_EXPIRE = 60 * 30;
    /** 不设置过期时长 */
    public static final long NOT_EXPIRE = -1;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ValueOperations<String, String> valueOperations;

    public enum RedisKeyEnum {

        TOKEN("token:{1}");

        private String key;

        RedisKeyEnum(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        /**
         * 获取redis缓存中的key
         *
         * @param obj key中的动态参数,不能为空
         * @return
         */
        public String getRedisCacheKey(Object... obj) {
            String temp = this.key;
            for (int i = 0; i < obj.length; i++) {
                if (-1 != temp.indexOf("{" + (i + 1) + "}")) {
                    temp = temp.replace("{" + (i + 1) + "}", obj[i].toString());
                }
            }
            return temp;
        }
    }

    public void set(String key, Object value, long expire) {
        valueOperations.set(key, toJson(value));
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    public void set(String key, Object value) {
        set(key, value, DEFAULT_EXPIRE);
    }

    public void setToken(String key, Object value) {
        String redisCacheKey = RedisKeyEnum.TOKEN.getRedisCacheKey(key);
        set(redisCacheKey, value, DEFAULT_EXPIRE);
    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        if (value != null) {
            return JSON.parseObject(value, clazz);
        }
        return null;
    }

    public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    public <T> T getToken(String key, Class<T> clazz) {
        if (key == null) {
            return null;
        }
        String redisCacheKey = RedisKeyEnum.TOKEN.getRedisCacheKey(key);
        return get(redisCacheKey, clazz, NOT_EXPIRE);
    }

    public String get(String key, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public String get(String key) {
        return get(key, NOT_EXPIRE);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * Object转成JSON数据
     */
    private String toJson(Object object) {
        if (object instanceof Integer || object instanceof Long || object instanceof Float ||
                object instanceof Double || object instanceof Boolean || object instanceof String) {
            return String.valueOf(object);
        }
        return JSONObject.toJSONString(object);
    }
}
