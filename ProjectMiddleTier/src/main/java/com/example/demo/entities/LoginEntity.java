package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logintable")
public class LoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int loginid;
	
	@Column
	String username;
	
	@Column
	String password;
	
//	@Column
//	String usertype;

	public LoginEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public LoginEntity(int loginid, String username, String password, String usertype) {
//		super();
//		this.loginid = loginid;
//		this.username = username;
//		this.password = password;
//		this.usertype = usertype;
//	}
	
	
	

	public int getLoginid() {
		return loginid;
	}




	public LoginEntity(int loginid, String username, String password) {
	super();
	this.loginid = loginid;
	this.username = username;
	this.password = password;
}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getUsertype() {
//		return usertype;
//	}
//
//	public void setUsertype(String usertype) {
//		this.usertype = usertype;
//	}

	
	
	
}
