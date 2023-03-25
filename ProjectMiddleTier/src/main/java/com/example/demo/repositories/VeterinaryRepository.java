package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Login;
import com.example.demo.entities.Veterinary;

public interface VeterinaryRepository extends JpaRepository<Veterinary, Integer> {

	@Query("select v from Veterinary v where loginid=:l")
	public Veterinary getVeterinary(Login l);
	
	@Query(value="select * from Veterinary v inner join logintable l on v.loginid=l.loginid where l.status=0",nativeQuery = true)
	public List <Veterinary> getVeterinarys();
	
	@Query("select v from Veterinary v where vetid=: id ")
	public Veterinary getVeterinaryWithid(int id);
}
