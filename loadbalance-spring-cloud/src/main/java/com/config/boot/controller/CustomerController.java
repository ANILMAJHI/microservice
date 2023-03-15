package com.config.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.config.boot.model.Customer;
import com.config.boot.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	//GetMapping("/customerDetials")
	@GetMapping("/customerDetials")
	public  List<Customer> getCustomer(String name)
	{
		List<Customer> customer=service.getCustomer(name);
		return customer;
		
	}
	
	@GetMapping("/message")
	public String getMessage()
	
	{
		return "hello message...";
	}
}
