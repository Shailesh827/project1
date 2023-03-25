package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Pet;
import com.example.demo.entities.PetRegister;
import com.example.demo.entities.Seller;
import com.example.demo.entities.Usertype;
import com.example.demo.service.PetService;
import com.example.demo.service.SellerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PetController {
	
	@Autowired
	PetService pservice;
	
	@Autowired
	SellerService sservice;
	
	@GetMapping("/getpet")
	public Pet getPet(@RequestParam("sellerid")int sellerid)
	{
		Seller s=sservice.getById(sellerid);
		return pservice.getPet(s);
	}
	
	@PostMapping("/regPet")
	public Pet regPet(@RequestBody PetRegister pr)
	{
		Seller s=sservice.getById(pr.getSellerid());
		Pet p=new Pet(pr.getPetname(),pr.getBreed(),pr.getColor(),pr.getGender(),pr.getType(),pr.getAge(),pr.getPrice(),s);
		return pservice.save(p);
		
	}
	
	@PostMapping(value="/uploadImage/{petid}",consumes ="Multipart/form-data")
	public boolean uploadImage(@PathVariable("petid") int petid,@RequestBody MultipartFile file)
	{
		System.out.println("petid"+petid);
		System.out.println(file.getName()+""+file.getContentType()+""+file.getOriginalFilename());
		boolean flag=true;
		try {	
			flag=pservice.upload(petid,file.getBytes());
		}
		catch(Exception e){
			System.out.println(e);
			flag=false;
		}
		return flag;
	}
	
	
	@GetMapping("getAllPet")
	public List<Pet> getAllPet()
	{
		return pservice.getAll();
	}
	
	
	


}
