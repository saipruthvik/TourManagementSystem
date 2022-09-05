package com.medplus.tourmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medplus.tourmanagement.entities.UserLogin;
import com.medplus.tourmanagement.service.UserLoginService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserLoginService userLoginService;

	@PostMapping
	public ResponseEntity<UserLogin> checkUserLogin(@RequestBody UserLogin user) {
		return new ResponseEntity<>(userLoginService.checkUserLogin(user), HttpStatus.OK);
	}

	@GetMapping("/getPassword/{userId}")
	public ResponseEntity<String> getPassword(@PathVariable("userId") int userId) {
		return new ResponseEntity<>(userLoginService.getPassword(userId).getPassword(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody UserLogin user) {
		UserLogin userLogin = userLoginService.addUser(user.getPassword(), user.getUserRole());
		return new ResponseEntity<>("Staff Added Completed Successfully and your User Id is " + userLogin.getUserId(),
				HttpStatus.OK);
	}

	@PutMapping("/{userId}/{password}")
	public ResponseEntity<String> updateUserPassword(@PathVariable("userId") int userId,
			@PathVariable("password") String password) {
		userLoginService.updateUserPassword(userId, password);
		return new ResponseEntity<>("Password Updated Successfully !!! and new Password is " + password, HttpStatus.OK);
	}

}
