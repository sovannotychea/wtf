/**
 * 
 */
package com.example.wtf.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author sovannoty
 *
 */
@Entity(name = "customer")
@Table(name = "customer")
public class Customer extends User{
	
	
	public Customer() {
		super();
	}

	public Customer(String userName, String firstName, String lastName) {
		super(userName,firstName,lastName);
	}
	
	public Customer(String userName, String phone) {
		super(userName,phone);
	}


}
