package com.xu.xuaicodemother;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xu.xuaicodemother.mapper")
public class XuAiCodeMotherApplication {

	public static void main(String[] args) {
		SpringApplication.run(XuAiCodeMotherApplication.class, args);
	}
}
