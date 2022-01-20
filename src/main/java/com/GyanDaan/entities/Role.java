package com.GyanDaan.entities;

import java.util.*;

import javax.persistence.*; 

@Entity	
public class Role {
	@Id
	private Long roleid;
	private String rolename;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
	private Set<UserRoles> userRoles = new HashSet<>();
	
	
	public Set<UserRoles> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}
	public Role() {
		super();
	}
	public Role(Long roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
	
	

}
