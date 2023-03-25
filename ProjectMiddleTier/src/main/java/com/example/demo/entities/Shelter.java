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
	String phone;
	public Shelter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shelter(String sheltername, String address, String phone) {
		super();
		this.sheltername = sheltername;
		this.address = address;
		this.phone = phone;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Shelter [shelterid=" + shelterid + ", sheltername=" + sheltername + ", address=" + address + ", phone="
				+ phone + "]";
	}
	
	
	
	
	
}
