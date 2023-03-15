package com.config.boot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.config.boot.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Customer> getCustomer(String name) {

		ResponseEntity<List<Customer>> responseEntity = null;
		List<Customer> listCustomer = null;
		String url = null;
		//String url = "http://DEPARTMENTDETAILS-SERVICE/application/allUsers";
		String urlApi = "http://localhost:9901/api/test";
		Map<String, Object> uriVarible = null;

		uriVarible = new HashMap<String, Object>();
		uriVarible.put("name", name);

		/*
		 * url = UriComponentsBuilder.fromUriString(
		 * "http://DEPARTMENTDETAILS-SERVICE/application/allUsers")
		 * .uriVariables(uriVarible).build().toString();
		 */

		 url=UriComponentsBuilder.fromUriString(urlApi).uriVariables(uriVarible).build().toString();
		
		/*
		 * url = UriComponentsBuilder.fromUriString(
		 * "http://localhost:9191/application/allUsers/")
		 * .uriVariables(uriVarible).build().toString();
		 */
		responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {
				});

		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			listCustomer = responseEntity.getBody();
		}

		return listCustomer;
	}

}
