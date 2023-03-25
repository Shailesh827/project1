package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Qualification;
import com.example.demo.service.QualificationService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class QualificationController {
	
	@Autowired
	QualificationService qservice;
	
	@GetMapping("/getAllQualification")
	public List<Qualification> getAll()
	{
		return qservice.getAll(); 
	}
	
	@GetMapping("/getQualification")
	public Qualification getQualification(@RequestParam(name="qualificationid")int qualificationid)
	{
		return qservice.findById(qualificationid); 
	}

}
