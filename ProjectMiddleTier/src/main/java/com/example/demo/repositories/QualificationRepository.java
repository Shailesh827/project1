package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Qualification;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Integer> {

}
