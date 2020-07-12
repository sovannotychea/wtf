package com.example.wtf.repo;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

public interface UserRepository<T> {

	Optional<T> findByPhoneNumber(String phoneNumber);

	Optional<T> findByUserName(String userName);

}
