/**
 * 
 */
package com.example.wtf.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author sovannoty
 *
 */
@MappedSuperclass
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public User() {

	}
	public User(String userName, String phoneNumber) {
		this.userName = userName;
		this.phoneNumber = phoneNumber;
	}

	public User(String userName, String firstName, String lastName) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Customer))
			return false;
		User employee = (User) o;
		return Objects.equals(this.getId(), employee.getId())
				&& Objects.equals(this.getUserName(), employee.getUserName())
				&& Objects.equals(this.getPhoneNumber(), employee.getPhoneNumber());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getId(), this.getUserName(), this.getPhoneNumber());
	}

}
