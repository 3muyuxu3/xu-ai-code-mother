package com.xu.xuaicodemother;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-05
 */
@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class})
@MapperScan("com.xu.xuaicodemother.mapper")
@EnableCaching
public class XuAiCodeAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(XuAiCodeAppApplication.class, args);
    }
}
