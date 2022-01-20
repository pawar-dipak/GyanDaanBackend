package com.GyanDaan.entities.teacher;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Skills {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sid;
	
	private String susername;
	private String sname;
	
	
	
	

	


	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Skills(String susername, String sname) {
		super();
		this.susername = susername;
		this.sname = sname;
	}


	public String getSusername() {
		return susername;
	}


	public void setSusername(String susername) {
		this.susername = susername;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	

	


	
	
	

}
