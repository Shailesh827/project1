package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Usertype;

@Repository
public interface UsertypeRepository extends JpaRepository<Usertype,Integer>{
	
	

}
