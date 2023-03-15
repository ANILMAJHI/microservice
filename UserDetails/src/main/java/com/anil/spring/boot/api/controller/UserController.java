package com.anil.spring.boot.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.spring.boot.api.exception.CustomeException;
import com.anil.spring.boot.api.model.User;
import com.anil.spring.boot.api.service.UserServiceImpl;

@RestController
//@Controller
@RequestMapping("/application")
public class UserController {

	@Autowired
	UserServiceImpl userImpl;

	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> listAllUsers() {

		List<User> user = userImpl.findAllUsers();
		if (user == null) {
			return new ResponseEntity(new CustomeException(":User not available...:"), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

	@GetMapping("/userId/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		User user = userImpl.findById(id);
		if (user == null) {
			return new ResponseEntity<>(new CustomeException(id + ":User Id is not found:"), HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<User>(user, HttpStatus.FOUND);
	}

	@GetMapping("/userName/{name}")
	public ResponseEntity<User> findByName(@PathVariable("name") String name) {

		User user = userImpl.findByName(name);

		if (StringUtils.isEmpty(user)) {

			return new ResponseEntity(new CustomeException(name + ":User not found :"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(user, HttpStatus.OK);
	}

	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		User allUser = userImpl.isUserExist(user);
		if (StringUtils.isEmpty(allUser)) {
			return new ResponseEntity(new CustomeException(":User already exits:"), HttpStatus.OK);
		}
		userImpl.saveUser(user);
		return new ResponseEntity(user + "User saved successfully...", HttpStatus.OK);

	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		// User allUser = userImpl.isExits(user);
		User allUser = userImpl.findById(id);

		if (allUser == null) {

			return new ResponseEntity(new CustomeException(id + ":User Id not exits:"), HttpStatus.OK);
		}

		allUser.setId(id);
		allUser.setName(user.getName());
		allUser.setAge(user.getAge());
		allUser.setSalary(user.getSalary());
		userImpl.updateUser(allUser);
		return new ResponseEntity(allUser+": User Successfully updated...", HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<User> deleteById(@PathVariable("id") long id) {
		User user = userImpl.findById(id);
		if (StringUtils.isEmpty(user)) {
			return new ResponseEntity(new CustomeException(id + ":is not available in DB, Pleaes check in DB..."), HttpStatus.NOT_FOUND);
		}
		userImpl.deleteById(id);
		return new ResponseEntity(user.getId() + ":Id Successfully deleted...", HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/deleteAlluser")
	public ResponseEntity<User> deleteAllUers() {
		User user = userImpl.isExits();
		if (user == null) {
			return new ResponseEntity(new CustomeException("User not available..."), HttpStatus.NO_CONTENT);
		}

		userImpl.findAllUser();
		return new ResponseEntity(HttpStatus.OK);
	}

}