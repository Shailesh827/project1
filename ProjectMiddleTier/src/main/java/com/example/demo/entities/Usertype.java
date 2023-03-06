package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usertypetable")
public class Usertype {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int usertypeid;
	
	@Column
	String usertype;

	
	
	public Usertype() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Usertype(String usertype) {
		super();
		this.usertype = usertype;
	}


	public int getUsertypeid() {
		return usertypeid;
	}


	public void setUsertypeid(int usertypeid) {
		this.usertypeid = usertypeid;
	}


	public String getUsertype() {
		return usertype;
	}


	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	

}
