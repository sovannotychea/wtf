/**
 * 
 */
package com.example.wtf.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.wtf.model.Person;
import com.example.wtf.repo.PersonRepository;

/**
 * @author sovannoty
 *
 */
@Component 
public class DatabaseLoader implements CommandLineRunner { 

	@Autowired
	private PersonRepository repository;
	

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Person("Frodo", "Baggins"));
	}
}
