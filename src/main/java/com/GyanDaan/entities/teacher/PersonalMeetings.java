package com.GyanDaan.entities.teacher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonalMeetings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tid;
	
	private String tUsername;
	private String tStudentUsername;
	private String tTopic;
	@Column(length = 1000)
	private String tDescription;
	private String tDate;
	private String tTime;
	private String tLink;
	public PersonalMeetings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonalMeetings(String tUsername, String tStudentUsername, String tTopic, String tDescription, String tDate,
			String tTime, String tLink) {
		super();
		this.tUsername = tUsername;
		this.tStudentUsername = tStudentUsername;
		this.tTopic = tTopic;
		this.tDescription = tDescription;
		this.tDate = tDate;
		this.tTime = tTime;
		this.tLink = tLink;
	}
	
	public long getTid() {
		return tid;
	}
	
	public String gettUsername() {
		return tUsername;
	}
	public void settUsername(String tUsername) {
		this.tUsername = tUsername;
	}
	public String gettStudentUsername() {
		return tStudentUsername;
	}
	public void settStudentUsername(String tStudentUsername) {
		this.tStudentUsername = tStudentUsername;
	}
	public String gettTopic() {
		return tTopic;
	}
	public void settTopic(String tTopic) {
		this.tTopic = tTopic;
	}
	public String gettDescription() {
		return tDescription;
	}
	public void settDescription(String tDescription) {
		this.tDescription = tDescription;
	}
	public String gettDate() {
		return tDate;
	}
	public void settDate(String tDate) {
		this.tDate = tDate;
	}
	public String gettTime() {
		return tTime;
	}
	public void settTime(String tTime) {
		this.tTime = tTime;
	}
	public String gettLink() {
		return tLink;
	}
	public void settLink(String tLink) {
		this.tLink = tLink;
	}
	
	

}
