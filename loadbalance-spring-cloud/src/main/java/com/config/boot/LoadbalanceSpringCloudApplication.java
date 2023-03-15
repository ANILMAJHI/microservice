package com.config.boot;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class LoadbalanceSpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadbalanceSpringCloudApplication.class, args);
	}

	/*
	 * @Bean
	 * 
	 * @LoadBalanced public RestTemplate template() { return new RestTemplate(); }
	 */
	
	@Bean
	@LoadBalanced
	public RestTemplate template(RestTemplateBuilder builder) {
		return builder.setConnectTimeout(Duration.ofMillis(3000)).setReadTimeout(Duration.ofMillis(3000)).build();
	}
}
