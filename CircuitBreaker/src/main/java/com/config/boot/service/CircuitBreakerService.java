package com.config.boot.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.config.boot.model.User;

@FeignClient(url="http://localhost:9900/application", name="CIRCUIT-BREAKER-APPLICATION")
public interface CircuitBreakerService {

	
	@GetMapping("/allUsers")
	public List<User> getAllUser();
	
	@GetMapping("/users/{id}")
	public List<User> getUserIdDetails(@PathVariable Long id);
	
}
