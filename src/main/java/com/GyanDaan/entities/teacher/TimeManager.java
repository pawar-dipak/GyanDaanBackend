package com.GyanDaan.entities.teacher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TimeManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tid;
	
	private String tUsername;
	private String tTopic;
	@Column(length = 1000)
	private String tDescription;
	private String tDate;
	private String tTime;
	private String tLink;
	
	public TimeManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TimeManager(String tUsername, String tTopic, String tDescription, String tDate, String tTime, String tLink) {
		super();
		this.tUsername = tUsername;
		this.tTopic = tTopic;
		this.tDescription = tDescription;
		this.tDate = tDate;
		this.tTime = tTime;
		this.tLink = tLink;
	}
	public String gettUsername() {
		return tUsername;
	}
	public void settUsername(String tUsername) {
		this.tUsername = tUsername;
	}
	public long getTid() {
		return tid;
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
	@Override
	public String toString() {
		return "TimeManager [Meeting Topic=" + tTopic + ", tDescription=" + tDescription + ", tDate=" + tDate + ", tTime="
				+ tTime + ", tLink=" + tLink + "]";
	}
	
	
	
	
	
	
	
	

}
