package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Shelter;
import com.example.demo.repositories.ShelterRepository;

@Service
public class ShelterService {

	@Autowired
	ShelterRepository srepo;
	
	public List<Shelter> getAll()
	{
		return srepo.findAll();
	}
	
}
