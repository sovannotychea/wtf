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
@Entity(name = "deliver")
@Table(name = "deliver")
public class Deliver extends User{

	
	public Deliver() {
		super();
	}

	public Deliver(String userName, String firstName, String lastName) {
		super(userName,firstName,lastName);
	}

	public Deliver(String userName, String phone) {
		super(userName,phone);
	}
}
