package com.config.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.config.boot.model.User;

@RestController
@RequestMapping("/api")

public class FeignClientController {

	@Autowired
	private FeignClientSerive service;

	@GetMapping(value = "/message")
	public List<User> UserDetails() {
		List<User> message = service.getUserDetails();
		return message;

	}

	@GetMapping(value ="/userId/{id}")
	public List<User> getUserId(Long id) {
		List<User> userDetialsId = service.getUserId(id);
		return userDetialsId;
	}
}
