package com.config.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {


	@GetMapping("/userFallback")
	public Mono<String> userDetailsServie(){
		return Mono.just("userDetailsService down the servie.....");
	}

	@GetMapping("/feignFallback")
	public Mono<String> feignFallbackServie(){
		return Mono.just("feignFallbackServie down the servie.....");
	}

	
}


