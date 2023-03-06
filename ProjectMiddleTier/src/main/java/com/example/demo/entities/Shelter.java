package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="shelter")
public class Shelter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int shelterid;
	@Column
	String sheltername;
	@Column
	String address;
	@Column
	String phoneno;
	
	
	
	public Shelter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Shelter(int shelterid, String sheltername, String address, String phoneno) {
		super();
		this.shelterid = shelterid;
		this.sheltername = sheltername;
		this.address = address;
		this.phoneno = phoneno;
	}

	public int getShelterid() {
		return shelterid;
	}
	public void setShelterid(int shelterid) {
		this.shelterid = shelterid;
	}
	public String getSheltername() {
		return sheltername;
	}
	public void setSheltername(String sheltername) {
		this.sheltername = sheltername;
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
	
	
	
}
