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
public class Deliver extends Person{

	public Deliver(String firstName, String lastName) {
		super(firstName, lastName);
	}

}
