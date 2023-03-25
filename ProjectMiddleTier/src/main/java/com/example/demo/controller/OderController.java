package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Buyer;
import com.example.demo.entities.Order;
import com.example.demo.entities.OrderRegister;
import com.example.demo.entities.Pet;
import com.example.demo.entities.Seller;
import com.example.demo.service.BuyerServices;
import com.example.demo.service.OrderService;
import com.example.demo.service.PetService;
import com.example.demo.service.SellerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OderController {
	@Autowired
	OrderService oservice;
	
	@Autowired
	PetService pservice;
	@Autowired
	SellerService sservice;
	@Autowired
	BuyerServices bservice;
	
	@PostMapping("/orderPet")
	public Order placeOrder(@RequestBody OrderRegister or)
	{
		Date date = null;
		//(Date orderdate, String paymenttype, int price, int transactionid, Pet petid, Seller sellerid,
		//Buyer buyerid 
		System.out.println(or.getBuyerid());
		System.out.println(or.getOrderdate());
		System.out.println(or.getPaymenttype());
		System.out.println(or.getPetid());
		System.out.println(or.getSellerid());
		System.out.println(or.getAmount());
		try {
			System.out.println(or.getOrderdate());
			 date=new SimpleDateFormat("yyyy-MM-dd").parse(or.getOrderdate());
		}
		catch (Exception e) {
			System.out.println(e);
		}
			Buyer b=bservice.getbyId(or.getBuyerid());
			Seller s=sservice.getById(or.getSellerid());
			Pet p=pservice.getById(or.getPetid());
		
		Order o=new Order(date,or.getPaymenttype(),or.getAmount(),or.getTransactionid(),p,s,b);
		pservice.UpdatePetStatus(or.getPetid());
		return oservice.save(o); 
	}

}
