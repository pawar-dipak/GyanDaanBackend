package com.GyanDaan.entities.Requests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonalRequests {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long rId;
	
	private String rUsername;
	private String rTeacherUsername;
	private String rTopic;
	@Column(length = 1000)
	private String rDescription;
	private String rStatus;
	private String rTime;
	private String rDate;
	
	public PersonalRequests() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	


	






	public PersonalRequests(String rUsername, String rTeacherUsername, String rTopic, String rDescription,
			String rStatus, String rTime, String rDate) {
		super();
		this.rUsername = rUsername;
		this.rTeacherUsername = rTeacherUsername;
		this.rTopic = rTopic;
		this.rDescription = rDescription;
		this.rStatus = rStatus;
		this.rTime = rTime;
		this.rDate = rDate;
	}













	public String getrTeacherUsername() {
		return rTeacherUsername;
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













	public void setrTeacherUsername(String rTeacherUsername) {
		this.rTeacherUsername = rTeacherUsername;
	}






	public long getrId() {
		return rId;
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

}
