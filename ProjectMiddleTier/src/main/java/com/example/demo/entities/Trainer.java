package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="trainer")
public class Trainer {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int trainerid;
	
    String fname, lname, regno, address, phoneno, description;
    

	@OneToOne
	@JoinColumn(name="loginid")
	Login loginid;


	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Trainer(String fname, String lname, String regno, String address, String phoneno, String description,
			Login loginid) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.regno = regno;
		this.address = address;
		this.phoneno = phoneno;
		this.description = description;
		this.loginid = loginid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getRegno() {
		return regno;
	}


	public void setRegno(String regno) {
		this.regno = regno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Login getLoginid() {
		return loginid;
	}


	public void setLoginid(Login loginid) {
		this.loginid = loginid;
	}
	
	

}
