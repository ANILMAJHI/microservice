package com.config.boot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.config.boot.model.User;
import com.config.boot.service.CircuitBreakerService;

import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;



@RestController
@RequestMapping("/mapping")
public class CBUserController {

	@Autowired
	CircuitBreakerService breakerService;

	private static final String USER_SERVICES = "user_services";

	private int attempt = 1;

	@GetMapping("/msg")
	public String getMessage() {
		return "message test...";
	}

	@GetMapping("/getCB")
	// @CircuitBreaker(name=USER_SERVICES, fallbackMethod = "getAllUserAvailable")
	//@Retry(name = USER_SERVICES, fallbackMethod = "getAllUserAvailable")
	@TimeLimiter(name = USER_SERVICES, fallbackMethod = "getAllUserAvailable")
	public List<User> getAllUser() {

		System.out.println("retry method called " + attempt++ + " times" + "at " + new Date());
		return breakerService.getAllUser();
	}

	public List<User> getAllUserAvailable(Exception e) {
		List<User> user = new ArrayList<>();
		user.add(new User(1, "Hari", 21, 20000));
		user.add(new User(2, "Ram", 23, 25000));
		user.add(new User(3, "Ganesh", 24, 30000));
		user.add(new User(4, "Shiva", 25, 35000));

		return user;
	}

	@GetMapping("/getID/{id}")
	public List<User> getUserIdDetails(@PathVariable Long id) {
		List<User> userDetialsId = breakerService.getUserIdDetails(id);
		return userDetialsId;

		// List<User> userDetialsId = service.getUserId(id);
		// return userDetialsId;
	}
}
