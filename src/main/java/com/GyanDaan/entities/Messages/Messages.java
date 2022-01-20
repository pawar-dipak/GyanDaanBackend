package com.GyanDaan.entities.Messages;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Messages {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mId;
	
	private String mUsername;
	private String mSubject;
	@Column(length = 1000)
	private String mMessage;
	private String mReplytoUsername;
	
	
	public Messages() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Messages(String mUsername, String mSubject, String mMessage, String mReplytoUsername) {
		super();
		this.mUsername = mUsername;
		this.mSubject = mSubject;
		this.mMessage = mMessage;
		this.mReplytoUsername = mReplytoUsername;
	}


	public Long getmId() {
		return mId;
	}


	


	public String getmUsername() {
		return mUsername;
	}


	public void setmUsername(String mUsername) {
		this.mUsername = mUsername;
	}


	public String getmSubject() {
		return mSubject;
	}


	public void setmSubject(String mSubject) {
		this.mSubject = mSubject;
	}


	public String getmMessage() {
		return mMessage;
	}


	public void setmMessage(String mMessage) {
		this.mMessage = mMessage;
	}


	public String getmReplytoUsername() {
		return mReplytoUsername;
	}


	public void setmReplytoUsername(String mReplytoUsername) {
		this.mReplytoUsername = mReplytoUsername;
	}
	
	
	
	

}
