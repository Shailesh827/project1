package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Login;
import com.example.demo.entities.Seller;
import com.example.demo.entities.SellerRegister;
import com.example.demo.entities.Usertype;
import com.example.demo.service.LoginService;
import com.example.demo.service.SellerService;
import com.example.demo.service.UsertypeServices;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class SellerController {

	@Autowired
	SellerService sservice;
	
	@Autowired
	LoginService lservice;
	
	@Autowired
	UsertypeServices uservice;
	
	@GetMapping("/getSeller")
	public Seller getSeller(@RequestParam(name="loginid")int Loginid)
	{
		Login l=lservice.getById(Loginid);
		return sservice.getSeller(l);
	}
	
	@PostMapping("/regSeller")
	public Seller regSeller(@RequestBody SellerRegister sr)
	{
		Usertype u=uservice.getUsertype(2);
		Login l=new Login(sr.getUsername(),sr.getPassword(),u,1);
		Login saved=lservice.save(l);
		
		Seller s=new Seller(sr.getFirstname(),sr.getLastname(),sr.getEmail(),sr.getAddress(),sr.getPhoneno(),sr.getAdharno(),saved);
	return sservice.saveSeller(s);
	}
}
