package com.anil.spring.boot.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
/*@SpringBootApplication(scanBasePackages={
		"com.anil.spring.boot.api"},exclude={DataSourceAutoConfiguration.class})*/
public class DepartmentDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentDetailsApplication.class, args);
		// System.out.println("this is the departments details application...");

	}

}
