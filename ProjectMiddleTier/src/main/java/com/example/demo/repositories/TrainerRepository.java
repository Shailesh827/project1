package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Login;

import com.example.demo.entities.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

	@Query("select t from Trainer t where loginid=:l")
	public Trainer getTrainer(Login l);
}
