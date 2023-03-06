package com.example.demo.repositories;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import com.example.demo.entities.Shelter;

public interface ShelterRepository extends JpaRepositoryImplementation<Shelter, Integer> {

	
}
