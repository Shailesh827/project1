package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Login;
import com.example.demo.entities.Trainer;
import com.example.demo.repositories.TrainerRepository;

@Service
public class TrainerService {
    @Autowired
	TrainerRepository trepo;
    
    public Trainer getTrainer(Login l)
	{
		return trepo.getTrainer(l);
	}
	
	public Trainer saveTrainer(Trainer t)
	{
		return trepo.save(t);
	}
}
