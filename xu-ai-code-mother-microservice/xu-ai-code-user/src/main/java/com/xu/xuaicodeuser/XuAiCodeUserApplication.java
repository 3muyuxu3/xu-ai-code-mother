package com.xu.xuaicodeuser;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-05
 */
@SpringBootApplication
@MapperScan("com.xu.xuaicodeuser.mapper")
@EnableDubbo
@ComponentScan("com.xu")
public class XuAiCodeUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(XuAiCodeUserApplication.class, args);
    }
}