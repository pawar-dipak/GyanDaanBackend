package com.GyanDaan.entities.Requests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AcceptedRequests {
	@Id
	private long rId;
	
	private String rUsername;
	private String rTopic;
	@Column(length = 1000)
	private String rDescription;
	private String rStatus;
	private String rTime;
	private String rDate;
	private String rTeacherUsername;
	public AcceptedRequests() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	


	
	public AcceptedRequests(String rUsername, String rTopic, String rDescription, String rStatus, String rTime,
			String rDate, String rTeacherUsername) {
		super();
		this.rUsername = rUsername;
		this.rTopic = rTopic;
		this.rDescription = rDescription;
		this.rStatus = rStatus;
		this.rTime = rTime;
		this.rDate = rDate;
		this.rTeacherUsername = rTeacherUsername;
	}









	public long getrId() {
		return rId;
	}




	public void setrId(long rId) {
		this.rId = rId;
	}



	
	public String getrTime() {
		return rTime;
	}









	public void setrTime(String rTime) {
		this.rTime = rTime;
	}









	public String getrDate() {
		return rDate;
	}









	public void setrDate(String rDate) {
		this.rDate = rDate;
	}









	public String getrUsername() {
		return rUsername;
	}
	public void setrUsername(String rUsername) {
		this.rUsername = rUsername;
	}
	public String getrTopic() {
		return rTopic;
	}
	public void setrTopic(String rTopic) {
		this.rTopic = rTopic;
	}
	public String getrDescription() {
		return rDescription;
	}
	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}
	public String getrTeacherUsername() {
		return rTeacherUsername;
	}
	public void setrTeacherUsername(String rTeacherUsername) {
		this.rTeacherUsername = rTeacherUsername;
	}
	
	
	
	

}
