package com.example.demo.controller;

import java.util.List;

import javax.persistence.PostUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Login;
import com.example.demo.entities.Shelter;
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
	public Trainer getTrainer(@RequestParam(name="loginid")int loginid)
	{
		System.out.println(loginid);
		Login l=lservice.getById(loginid);
		return tservice.getTrainer (l);
	}
	
	@PostMapping("/regTrainer")
	public Trainer regTrainer(@RequestBody TrainerRegister tr)
	{
		System.out.println(tr.getPassword());
		Usertype u=uservice.getUsertype(3);
		Login l=new Login(tr.getUsername(),tr.getPassword(),u,1);
		Login saved=lservice.save(l);
		
		Trainer t=new Trainer(tr.getFname(),tr.getLname(),tr.getRegno(),tr.getAddress(),tr.getPhone(),tr.getDescription(),saved);
	return tservice.saveTrainer(t);
	}
	
	@GetMapping("/getTrainerlist")
	public List<Trainer> getAll()
	{
		return tservice.getAll();
	}
	
	@GetMapping("/getTrainerWithStatus0")
	public List<Trainer> getTrainerWithStatus()
	{
		return tservice.getTrainerWithStatus();
	}

	
	
}
