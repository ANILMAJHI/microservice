package com.config.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatroController {

	@GetMapping("/view")
	public String ViewActuator()
	{
		return "This is view Actuator";
	}
}
