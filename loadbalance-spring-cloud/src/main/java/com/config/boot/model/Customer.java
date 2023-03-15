package com.config.boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private int id;
	private String name;
	private String gender;
	private int age;
	private String address;
	
	
}
