package com.config.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringHaEurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHaEurekaserverApplication.class, args);
	}

}
