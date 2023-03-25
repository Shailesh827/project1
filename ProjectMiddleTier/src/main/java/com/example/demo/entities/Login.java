package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="logintable")
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int loginid;
	
	@Column
	String username;
	
	@Column
	String password;
	
	@ManyToOne
	@JoinColumn(name="usertypeid")
	Usertype usertypeid;
	
	@Column
	int status;
	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Login(String username, String password, Usertype usertypeid, int status) {
		super();
		this.username = username;
		this.password = password;
		this.usertypeid = usertypeid;
		this.status = status;
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

	public Usertype getUsertypeid() {
		return usertypeid;
	}

	public void setUsertypeid(Usertype usertypeid) {
		this.usertypeid = usertypeid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	public int getLoginid() {
		return loginid;
	}


	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}


	
	
	
	
}
