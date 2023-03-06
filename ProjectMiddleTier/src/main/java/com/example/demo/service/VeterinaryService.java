package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Login;
import com.example.demo.entities.Veterinary;
import com.example.demo.repositories.VeterinaryRepository;

@Service
public class VeterinaryService {

	@Autowired
	VeterinaryRepository vrepo;
	
	public Veterinary getVeterinary(Login l)
	{
		return vrepo.getVeterinary(l);
	}
	
	public Veterinary saveVeterinary(Veterinary v)
	{
		return vrepo.save(v);
	}
}
