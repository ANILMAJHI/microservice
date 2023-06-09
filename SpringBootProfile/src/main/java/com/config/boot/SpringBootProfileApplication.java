package com.config.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.config.boot.profileBean.ConnectionManager;

@SpringBootApplication
public class SpringBootProfileApplication {

	public static void main(String[] args) {
		ApplicationContext ct= SpringApplication.run(SpringBootProfileApplication.class, args);
		
		//ApplicationContext ct=new ApplicationContext(SpringBootProfileApplication.class)
		ConnectionManager ma=ct.getBean(ConnectionManager.class);
		System.out.println(ma);
				
	}

}
