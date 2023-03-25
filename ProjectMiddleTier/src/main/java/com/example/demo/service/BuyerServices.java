package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Buyer;
import com.example.demo.entities.Login;
import com.example.demo.repositories.BuyerRepository;

@Service
public class BuyerServices {

	@Autowired
	BuyerRepository brepo;
	
	public Buyer getBuyer(Login l)
	{
		return brepo.getBuyer(l);
	}
	
	public Buyer saveBuyer(Buyer b)
	{
		return brepo.save(b);
	}
	
	public Buyer getbyId(int buyerid)
	{
		return brepo.findById(buyerid).get();
	}
}
