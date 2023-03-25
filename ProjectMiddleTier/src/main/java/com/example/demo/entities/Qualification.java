package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qualification")
public class Qualification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int qualificationid;
	
	@Column
	String qualification;

	public Qualification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Qualification(String qualification) {
		super();
		this.qualification = qualification;
	}

	public int getQualificationid() {
		return qualificationid;
	}

	public void setQualificationid(int qualificationid) {
		this.qualificationid = qualificationid;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	

}
