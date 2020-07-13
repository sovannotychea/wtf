/**
 * 
 */
package com.example.wtf.model;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author sovannoty
 *
 */
@Entity
@Table(name = "user_account")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "phone_number", unique = true, length = 10)
	private String phoneNumber;
	
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String email;

	private boolean enabled;

	public User() {

	}

	public User(String userName, String phoneNumber) {
		this.userName = userName;
		this.phoneNumber = phoneNumber;
	}
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(final Collection<Role> roles) {
		this.roles = roles;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(final String username) {
		this.email = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof User))
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

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", phoneNumber=").append(phoneNumber).append(", userName=")
				.append(userName).append(", firstName=").append(firstName).append(", lastName=").append(lastName)
				.append(", email=").append(email).append(", enabled=").append(enabled).append(", roles=").append(roles)
				.append("]");
		return builder.toString();
	}

}
