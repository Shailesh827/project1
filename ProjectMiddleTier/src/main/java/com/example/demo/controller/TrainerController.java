package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Login;

import com.example.demo.entities.Trainer;
import com.example.demo.entities.TrainerRegister;
import com.example.demo.entities.Usertype;
import com.example.demo.service.LoginService;
import com.example.demo.service.TrainerService;
import com.example.demo.service.UsertypeServices;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class TrainerController {
    @Autowired
	TrainerService tservice;
    
    @Autowired
	LoginService lservice;
	
	@Autowired
	UsertypeServices uservice;
	
	@GetMapping("/getTrainer")
	public Trainer getTrainer (@RequestParam(name="loginid")int Loginid)
	{
		Login l=lservice.getById(Loginid);
		return tservice.getTrainer (l);
	}
	
	@PostMapping("/regTrainer")
	public Trainer regTrainer(@RequestBody TrainerRegister tr)
	{
		Usertype u=uservice.getUsertype(3);
		Login l=new Login(tr.getUsername(),tr.getPassword(),u,1);
		Login saved=lservice.save(l);
		
		Trainer t=new Trainer(tr.getFname(),tr.getLname(),tr.getRegno(),tr.getAddress(),tr.getPhoneno(),tr.getDescription(),saved);
	return tservice.saveTrainer(t);
	}
}
