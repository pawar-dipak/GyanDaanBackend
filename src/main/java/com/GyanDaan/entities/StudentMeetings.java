package com.GyanDaan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.GyanDaan.entities.teacher.PersonalMeetings;
import com.GyanDaan.entities.teacher.TimeManager;

@Entity
public class StudentMeetings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long tid;
	
	private String tUsername;
	private String tStudentUsername;
	private String tTopic;
	@Column(length = 1000)
	private String tDescription;
	private String tDate;
	private String tTime;
	private String tLink;
	
	
	
	public StudentMeetings() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public StudentMeetings(TimeManager timeManager,String username) {
		super();
		this.tStudentUsername = username;
		this.tid = timeManager.getTid();
		this.tUsername = timeManager.gettUsername();
		
		this.tTopic = timeManager.gettTopic();
		this.tDescription = timeManager.gettDescription();
		this.tDate = timeManager.gettDate();
		this.tTime = timeManager.gettTime();
		this.tLink = timeManager.gettLink();
	}
	public StudentMeetings(PersonalMeetings personalMeetings) {
		super();
		
		this.tid = personalMeetings.getTid();
		this.tUsername = personalMeetings.gettUsername();
		this.tStudentUsername = personalMeetings.gettStudentUsername();
		this.tTopic = personalMeetings.gettTopic();
		this.tDescription = personalMeetings.gettDescription();
		this.tDate = personalMeetings.gettDate();
		this.tTime = personalMeetings.gettTime();
		this.tLink = personalMeetings.gettLink();
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
