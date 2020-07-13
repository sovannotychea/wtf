/**
 * 
 */
package com.example.wtf.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.wtf.model.User;
import com.example.wtf.repo.UserRepository;

/**
 * @author sovannoty
 *
 */
@Component("beforeCreateUserValodator")
public class UserValodator implements Validator {
	
	@Autowired
	private UserRepository userRepository;

	@Override
    public void validate(Object obj, Errors errors) {

    	User user = (User) obj;
        if (checkInputString(user.getUserName())) {
            errors.rejectValue("UserName", "UserName.empty");
        }

        if (checkInputString(user.getPhoneNumber())) {
            errors.rejectValue("PhoneNumber", "PhoneNumber.empty");
        }
        
        User deliver = this.userRepository.findByPhoneNumber(user.getPhoneNumber());
        
        if(deliver != null) {
        	 errors.rejectValue("PhoneNumber", "PhoneNumber.exist");
        }
        deliver = this.userRepository.findByUserName(user.getUserName());

		if (deliver != null ) {
			errors.rejectValue("userName", "userName.exist");
		}
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }


	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
}
