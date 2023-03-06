package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Usertype;
import com.example.demo.repositories.UsertypeRepository;

@Service
public class UsertypeServices {
	
	
	@Autowired
	UsertypeRepository rrepo;
	
	public Usertype getUsertype(int id)
	{
		return rrepo.findById(id).get();
	}
}
