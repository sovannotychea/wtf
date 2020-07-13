package com.example.wtf.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.wtf.model.User;

public interface UserRepository<T> extends PagingAndSortingRepository<User, Long> {

	User findByPhoneNumber(String phoneNumber);

	User findByUserName(String userName);

}
