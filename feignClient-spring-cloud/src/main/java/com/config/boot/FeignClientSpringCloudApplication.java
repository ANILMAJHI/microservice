package com.config.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignClientSpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientSpringCloudApplication.class, args);
	}

}
