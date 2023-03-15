package com.anil.spring.boot.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.spring.boot.api.model.Department;
import com.anil.spring.boot.api.service.DepartmentServiceImpl;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	DepartmentServiceImpl service;

	@GetMapping("/test")
	public String MessageResponse() {
		return "Return the message...";
	}

	@PostMapping("/saveDept")
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
		// List<Department> dept=service.saveDepartment(department);
		return new ResponseEntity<Department>(service.saveDepartment(department), HttpStatus.OK);
	}

}
