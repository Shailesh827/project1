package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Login;
import com.example.demo.entities.Seller;
import com.example.demo.entities.Shelter;
import com.example.demo.service.LoginService;
import com.example.demo.service.SellerService;
import com.example.demo.service.ShelterService;
import com.example.demo.service.UsertypeServices;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ShelterController {

	@Autowired
	ShelterService sservice;
	
	@Autowired
	LoginService lservice;
	
	@Autowired
	UsertypeServices uservice;
	
	@GetMapping("/getShelter")
	public List<Shelter> getAll()
	{
		
		return sservice.getAll();
	}
}	