package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Login;
import com.example.demo.entities.Veterinary;

public interface VeterinaryRepository extends JpaRepository<Veterinary, Integer> {

	@Query("select v from Veterinary v where loginid=:l")
	public Veterinary getVeterinary(Login l);
}
