package com.example.wtf.validator;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.wtf.model.Deliver;
import com.example.wtf.repo.DeliverRepository;


@Component("beforeCreateDeliverValidator")
public class DeliverValidator implements Validator {
	
	@Autowired
	 private DeliverRepository deliverRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Deliver.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {

    	Deliver user = (Deliver) obj;
        if (checkInputString(user.getUserName())) {
            errors.rejectValue("UserName", "UserName.empty");
        }

        if (checkInputString(user.getPhoneNumber())) {
            errors.rejectValue("PhoneNumber", "PhoneNumber.empty");
        }
        
        Optional<Deliver> deliver = deliverRepository.findByPhoneNumber(user.getPhoneNumber());
        
        if(deliver.get() != null) {
        	 errors.rejectValue("PhoneNumber", "PhoneNumber.exist");
        }
        
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}