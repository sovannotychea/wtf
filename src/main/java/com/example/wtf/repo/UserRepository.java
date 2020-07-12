package com.example.wtf.repo;

import java.util.Optional;

public interface UserRepository<T> {
	
	Optional<T> findByPhoneNumber(String phoneNumber);
	
	Optional<T> findByUserName(String userName);

}
