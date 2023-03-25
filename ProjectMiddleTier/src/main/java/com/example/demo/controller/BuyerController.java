package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Buyer;
import com.example.demo.entities.BuyerRegister;
import com.example.demo.entities.Login;
import com.example.demo.entities.Usertype;
import com.example.demo.service.BuyerServices;
import com.example.demo.service.LoginService;
import com.example.demo.service.UsertypeServices;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class BuyerController {

	@Autowired
	BuyerServices bservice;
	
	@Autowired
	LoginService lservice;
	
	@Autowired
	UsertypeServices uservice;
	
	@GetMapping("/getBuyer")
	public Buyer getBuyer(@RequestParam(name="loginid")int Loginid)
	{
		Login l=lservice.getById(Loginid);
		return bservice.getBuyer(l);
	}
	
	@PostMapping("/regBuyer")
	public Buyer regBuyer(@RequestBody BuyerRegister br)
	{
		Usertype u=uservice.getUsertype(1);
		Login l=new Login(br.getUsername(),br.getPassword(),u,1);
		Login saved=lservice.save(l);
		Buyer b=new Buyer(br.getFirstname(),br.getLastname(),br.getEmail(),br.getAddress(),br.getPhone(),br.getAdharno(),saved);
	return bservice.saveBuyer(b);
	}
	
	@GetMapping("/getBuyerWithId")
	public Buyer getBuyerWithId(@RequestParam("buyerid")int buyerid)
	{
		return bservice.getbyId(buyerid);
	}
}
