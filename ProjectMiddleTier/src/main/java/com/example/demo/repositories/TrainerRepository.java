package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Login;

import com.example.demo.entities.Trainer;

@Repository
@Transactional
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

	@Query("select t from Trainer t where loginid=:l")
	public Trainer getTrainer(Login l);
	
	@Query(value="select * from trainer t inner join logintable l on t.loginid=l.loginid where l.status=0",nativeQuery = true)
	public List<Trainer> getTrainers();
	
	
	
	@Query("select t from Trainer t where trainerid=:id")
	public Trainer getTrainerWithid(int id);

	
}
