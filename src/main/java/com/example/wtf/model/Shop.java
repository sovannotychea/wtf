/**
 * 
 */
package com.example.wtf.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author sovannoty
 *
 */
@Entity(name = "shop")
@Table(name = "shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String address;
	
	private String phoneNumber;
	
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> menu;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Item> getMenu() {
		return menu;
	}

	public void setMenu(List<Item> menu) {
		this.menu = menu;
	}

}