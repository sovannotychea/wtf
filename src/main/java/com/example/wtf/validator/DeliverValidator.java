package com.example.wtf.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.wtf.model.Deliver;
import com.example.wtf.repo.DeliverRepository;
import com.example.wtf.repo.UserRepository;


@Component("beforeCreateDeliverValidator")
public class DeliverValidator extends UserValodator {
	
	@Autowired
	private DeliverRepository deliverRepository;
	
	public UserRepository getUserRepository() {
		return deliverRepository;
	}

    @Override
    public boolean supports(Class<?> clazz) {
        return Deliver.class.equals(clazz);
    }

    
}