package com.example.wtf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wtf.model.Customer;
import com.example.wtf.repo.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;
	
	
	 @PostMapping("/customer")
	  Customer newEmployee(@RequestBody Customer newEmployee) {
	    return repository.save(newEmployee);
	  }
}
