package com.config.boot.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.config.boot.model.User;

@FeignClient(url="http://localhost:9900/application", name="USER-CLIENT")
interface FeignClientSerive {

	@GetMapping(value="/allUsers")
	public List<User> getUserDetails();
	
	@GetMapping(value="/userId/{id}")
	public List<User> getUserId(@PathVariable("id") Long id);
	
}
