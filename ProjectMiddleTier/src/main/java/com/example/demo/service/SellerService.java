package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Login;
import com.example.demo.entities.Seller;
import com.example.demo.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	SellerRepository srepo;
	
	public Seller getSeller(Login l)
	{
		return srepo.getSeller(l);
	}
	
	public Seller saveSeller(Seller s)
	{
		return srepo.save(s);
	}
}
