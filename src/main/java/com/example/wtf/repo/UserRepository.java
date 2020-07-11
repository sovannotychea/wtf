/**
 * 
 */
package com.example.wtf.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.wtf.model.User;

/**
 * @author sovannoty
 *
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	
	List<User> findAll();
	
	List<User> findByLastName(@Param("name") String name);
  
  
  

}
