package com.xu.xuaicodemother;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xu
 * @version 1.0
 * @CreateTime: 2025-09-05
 */
@SpringBootApplication
@EnableDubbo
public class XuAiCodeScreenshotApplication {
    public static void main(String[] args) {
        SpringApplication.run(XuAiCodeScreenshotApplication.class, args);
    }
}