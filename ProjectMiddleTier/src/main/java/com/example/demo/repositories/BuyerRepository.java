package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Buyer;
import com.example.demo.entities.Login;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

	@Query("select b from Buyer b where loginid=:l")
	public Buyer getBuyer(Login l);
}
