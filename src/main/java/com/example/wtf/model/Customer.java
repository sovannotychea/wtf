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
public class Customer extends Person{

	public Customer(String firstName, String lastName) {
		super(firstName, lastName);
	}

}
