/**
 * 
 */
package com.example.wtf.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author sovannoty
 *
 */
@Entity(name = "orders")
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private Shop shop;
	
	@ManyToOne
	private User owner;

	@ManyToOne
	private User deliver;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Item> items;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<TrackingHistory> trackingHistories;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}


	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getDeliver() {
		return deliver;
	}

	public void setDeliver(User deliver) {
		this.deliver = deliver;
	}

	public Collection<Item> getItems() {
		return items;
	}

	public void setItems(Collection<Item> items) {
		this.items = items;
	}

	public Collection<TrackingHistory> getTrackingHistories() {
		return trackingHistories;
	}

	public void setTrackingHistories(Collection<TrackingHistory> trackingHistories) {
		this.trackingHistories = trackingHistories;
	}

}
