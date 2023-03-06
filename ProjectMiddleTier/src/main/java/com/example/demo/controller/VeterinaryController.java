package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Login;
import com.example.demo.entities.Usertype;
import com.example.demo.entities.Veterinary;
import com.example.demo.entities.VeterinaryRegister;
import com.example.demo.service.LoginService;
import com.example.demo.service.UsertypeServices;
import com.example.demo.service.VeterinaryService;

@CrossOrigin (origins="http://localhost:3000")
@RestController
public class VeterinaryController {

	@Autowired
	VeterinaryService vservice;
	
	@Autowired
	LoginService lservice;
	
	@Autowired
	UsertypeServices uservice;
	
	@GetMapping("/getVeterinary")
	public Veterinary getVeterinary(@RequestParam(name="loginid")int Loginid)
	{
		Login l=lservice.getById(Loginid);
		return vservice.getVeterinary(l);
	}
	
	@PostMapping("/regVerterinary")
	public Veterinary regVerterinary(@RequestBody VeterinaryRegister vr)
	{
		Usertype u=uservice.getUsertype(4);
		Login l=new Login(vr.getUsername(),vr.getPassword(),u,1);
		Login saved=lservice.save(l);
		
		Veterinary v= new Veterinary(vr.getVetname(), vr.getRegno(), vr.getHospitalname(),vr.getQualification(),vr.getPhoneno(),vr.getAddress(),saved);
		return vservice.saveVeterinary(v);
	}
}
