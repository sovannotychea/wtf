/**
 * 
 */
package com.example.wtf.validator;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.wtf.model.Deliver;
import com.example.wtf.repo.UserRepository;

/**
 * @author sovannoty
 *
 */
abstract class UserValodator implements Validator {
	
	
	UserRepository userRepository;

	public abstract UserRepository getUserRepository() ;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
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
        
        Optional<Deliver> deliver = this.getUserRepository().findByPhoneNumber(user.getPhoneNumber());
        
        if(deliver.get() != null) {
        	 errors.rejectValue("PhoneNumber", "PhoneNumber.exist");
        }
        deliver = this.getUserRepository().findByUserName(user.getUserName());

		if (deliver.isPresent()) {
			errors.rejectValue("userName", "userName.exist");
		}
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
