/**
 * 
 */
package com.example.wtf.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.wtf.model.User;
import com.example.wtf.repo.UserRepository;

/**
 * @author sovannoty
 *
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new User("tester01", "Frodo", "Baggins"));
		this.repository.save(new User("admin", "Sovannoty", "Chea"));
	}
}
