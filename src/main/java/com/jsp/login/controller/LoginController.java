package com.jsp.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.login.entity.User;
import com.jsp.login.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/signup")
	ResponseEntity<User> signup(@RequestBody User u1){
		return new ResponseEntity<User>(loginService.singup(u1),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/login")
	ResponseEntity login(@RequestHeader String value,@RequestHeader String password){
		return new ResponseEntity(loginService.login(value, password),HttpStatus.FOUND);
	}
	

	@GetMapping("/verify")
	ResponseEntity<User> verifyById(@RequestHeader int otp){
		return new ResponseEntity<User>(loginService.verifyOtp(otp),HttpStatus.ACCEPTED);
	}
}
