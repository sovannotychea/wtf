package com.example.wtf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wtf.model.User;
import com.example.wtf.repo.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;

	@PostMapping("/user")
	User newEmployee(@RequestBody User newUser) {
		User user = (User) repository.save(newUser);
		return user;
	}
}
