package com.acp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acp.entity.User;
import com.acp.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController{
	
	@Autowired
	UserServiceImpl userservice;
	
	@PostMapping("/validate")
	public User validateUser(@RequestParam(name="username") String username,@RequestParam(name="password") String password) {
		System.out.println(username+" "+password);
		User user = userservice.validate(username,password);
		return user;
	}

}
