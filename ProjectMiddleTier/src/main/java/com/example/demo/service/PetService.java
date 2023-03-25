package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Pet;
import com.example.demo.entities.Seller;
import com.example.demo.repositories.PetRepository;

@Service
public class PetService {

	@Autowired
	PetRepository prepo;
	
	public Pet getPet(Seller s)
	{
		return prepo.getPet(s);
	}
	
	public Pet save(Pet p)
	{
		return prepo.save(p);
	}
	
	public boolean upload(int petid,byte []photo)
	{
		System.out.println(photo);
		if((prepo.upload(petid,photo)) == 1)
			return true;
		else
			return false;
	}

	
	public List<Pet> getAll()
	{
		return prepo.getAllPet();
	}
	
	public Pet getById(int petid)
	{
		return prepo.findById(petid).get();
	}
	
	
	public int UpdatePetStatus(int petid)
	{
		return prepo.uploadPetStatus(petid);
	}
	
	
	
	
}
