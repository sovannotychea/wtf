package com.example.wtf.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.wtf.model.Customer;
import com.example.wtf.repo.CustomerRepository;
import com.example.wtf.repo.UserRepository;

@Component("beforeCreateCustomerValidator")
public class CustomerValidator extends UserValodator{

	@Autowired
	private CustomerRepository customerRepository;
	
	public UserRepository getUserRepository() {
		return customerRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.equals(clazz);
	}

}