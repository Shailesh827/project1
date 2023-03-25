package com.example.demo.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name="veterinary")
public class Veterinary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int vetid;
    
    
	String vetname;
	String  regno;
	String hospitalname;
	String  phone;
	String address;
	
	
	@OneToOne
	@JoinColumn(name="qualificationid")
	Qualification qualificationid;
	
	@OneToOne
	@JoinColumn(name="loginid")
	Login loginid;
	
	public Veterinary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Veterinary(String vetname, String regno, String hospitalname, String phone, String address,
			Qualification qualificationid, Login loginid) {
		super();
		this.vetname = vetname;
		this.regno = regno;
		this.hospitalname = hospitalname;
		this.phone = phone;
		this.address = address;
		this.qualificationid = qualificationid;
		this.loginid = loginid;
	}

	public int getVetid() {
		return vetid;
	}

	public void setVetid(int vetid) {
		this.vetid = vetid;
	}

	public String getVetname() {
		return vetname;
	}

	public void setVetname(String vetname) {
		this.vetname = vetname;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getHospitalname() {
		return hospitalname;
	}

	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Qualification getQualificationid() {
		return qualificationid;
	}

	public void setQualificationid(Qualification qualificationid) {
		this.qualificationid = qualificationid;
	}

	public Login getLoginid() {
		return loginid;
	}

	public void setLoginid(Login loginid) {
		this.loginid = loginid;
	}

	

	
}