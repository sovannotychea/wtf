/**
 * 
 */
package com.example.wtf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author sovannoty
 *
 */
@Entity
@Table(name = "tracking_history")
public class TrackingHistory {
	
	
	@Id
	@GeneratedValue
    private int id;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User handler;
    
	@Column(name="DATE_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private TrackingStage trackingStage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getHandler() {
		return handler;
	}

	public void setHandler(User handler) {
		this.handler = handler;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public TrackingStage getTrackingStage() {
		return trackingStage;
	}

	public void setTrackingStage(TrackingStage trackingStage) {
		this.trackingStage = trackingStage;
	}

}
