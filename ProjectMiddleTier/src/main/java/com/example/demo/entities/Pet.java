package com.example.demo.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.entities.Seller;

@Entity
@Table(name="pet_table")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int petid;
	
	String petname,breed,color,gender,type;
	int age;
	
	float price;
	
	byte[] image;
	
	
	@OneToOne
	@JoinColumn(name="sellerid")
	Seller sellerid;
	

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Pet(String petname, String breed, String color, String gender, String type, int age, float price,
			Seller sellerid) {
		super();
		this.petname = petname;
		this.breed = breed;
		this.color = color;
		this.gender = gender;
		this.type = type;
		this.age = age;
		this.price = price;
		this.sellerid = sellerid;
	}
	

	public Pet(int petid, String petname, String breed, String color, String gender, String type, int age, float price,
			byte[] image, Seller sellerid) {
		super();
		this.petid = petid;
		this.petname = petname;
		this.breed = breed;
		this.color = color;
		this.gender = gender;
		this.type = type;
		this.age = age;
		this.price = price;
		this.image = image;
		this.sellerid = sellerid;
		System.out.println("in constroctor "+petid);
	}

	public int getPetid() {
		return petid;
	}

	public void setPetid(int petid) {
		this.petid = petid;
	}

	public String getPetname() {
		return petname;
	}

	public void setPetname(String petname) {
		this.petname = petname;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Seller getSellerid() {
		return sellerid;
	}

	public void setSellerid(Seller sellerid) {
		this.sellerid = sellerid;
	}

	
}
