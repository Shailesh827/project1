package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Qualification;
import com.example.demo.entities.Usertype;
import com.example.demo.repositories.QualificationRepository;

@Service
public class QualificationService {

	@Autowired
	QualificationRepository qrepo;
	
	public List<Qualification> getAll()
	{
		return qrepo.findAll();
	}
	
	public Qualification findById(int id)
	{
		return qrepo.findById(id).get();
	}
	
	

}
