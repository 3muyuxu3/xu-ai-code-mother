package com.xu.xuaicodemother.ratelimit.enums;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-03
 */
public enum RateLimitType {

    /**
     * 接口级别限流
     */
    API,

    /**
     * 用户级别限流
     */
    USER,

    /**
     * IP级别限流
     */
    IP
}

