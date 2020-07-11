/**
 * 
 */
package com.example.wtf.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.wtf.model.Customer;

/**
 * @author sovannoty
 *
 */
@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

	
	List<Customer> findAll();
	
	List<Customer> findByLastName(@Param("name") String name);
  
  
  

}
