package com.example.VK_Bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Старт приложения
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class VkBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(VkBotApplication.class, args);
	}
}
