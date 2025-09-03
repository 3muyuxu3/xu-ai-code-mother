package com.xu.xuaicodemother.utils;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;

/**
 * @author xu
 * @version 1.0
 * @CreateTime: 2025-09-03
 * 缓存 key 生成工具类
 */
public class CacheKeyUtils {

    /**
     * 根据对象生成缓存key (JSON + MD5)
     *
     * @param obj 要生成key的对象
     * @return MD5哈希后的缓存key
     */
    public static String generateKey(Object obj) {
        if (obj == null) {
            return DigestUtil.md5Hex("null");
        }
        // 先转JSON，再MD5
        String jsonStr = JSONUtil.toJsonStr(obj);
        return DigestUtil.md5Hex(jsonStr);
    }
}