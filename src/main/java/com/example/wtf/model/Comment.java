package com.example.wtf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author sovannoty
 *
 */
@Entity(name = "comment")
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue
	private long id;

	private float rate;
	
	private String review;
	
	@ManyToOne
    @JoinColumn(name="owner_id")
	private Customer owner;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	
	
	
}