package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Login;
import com.example.demo.entities.Seller;


public interface SellerRepository extends JpaRepository<Seller, Integer> {

	@Query("select s from Seller s where loginid=:l")
	public Seller getSeller(Login l);
	
	
}
