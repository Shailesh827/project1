package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Pet;
import com.example.demo.entities.Seller;

@Transactional
@Repository
public interface PetRepository extends JpaRepository<Pet,Integer> {

	@Query("select p from Pet p where sellerid=:s")
	public Pet getPet(Seller s);
	
	@Query(value = "select * from pet_table where status=0",nativeQuery = true)
	public List<Pet> getAllPet();
	
	@Modifying
	@Query("update Pet set image=:file where petid=:id")
	public int upload(int id,byte [] file);
	
	@Modifying
	@Query("update Pet set status=1 where petid=:id")
	public int uploadPetStatus(int id);
	
	

	
}
