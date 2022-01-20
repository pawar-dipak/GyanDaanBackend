package com.GyanDaan.entities;

import javax.persistence.*;

@Entity
public class UserRoles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userroleid;
	private String username;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;

	public UserRoles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getUserroleid() {
		return userroleid;
	}

	public void setUserroleid(Long userroleid) {
		this.userroleid = userroleid;
	}

	public String getUsername() {
		return username;
	}

//	public void setUsername(String username) {
//		this.username = user.getName();
//	}

	public User getUser() {
		
		return user;
	}

	public void setUser(User user) {
		this.username = user.getName();
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

}
