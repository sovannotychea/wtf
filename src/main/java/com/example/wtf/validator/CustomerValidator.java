package com.example.wtf.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.wtf.model.Customer;
import com.example.wtf.repo.CustomerRepository;

@Component("beforeCreateCustomerValidator")
public class CustomerValidator implements Validator {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		Customer user = (Customer) obj;
		if (checkInputString(user.getUserName())) {
			errors.rejectValue("UserName", "UserName.empty");
		}

		if (checkInputString(user.getPhoneNumber())) {
			errors.rejectValue("PhoneNumber", "PhoneNumber.empty");
		}

		Optional<Customer> deliver = customerRepository.findByPhoneNumber(user.getPhoneNumber());

		if (deliver.get() != null) {
			errors.rejectValue("PhoneNumber", "PhoneNumber.exist");
		}
		
		deliver = customerRepository.findByUserName(user.getUserName());

		if (deliver.get() != null) {
			errors.rejectValue("UserName", "UserName.exist");
		}
	}

	private boolean checkInputString(String input) {
		return (input == null || input.trim().length() == 0);
	}
}