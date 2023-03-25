package com.example.demo.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Login;
import com.example.demo.entities.LoginEntity;


@Repository
@Transactional
public interface LoginRepository extends JpaRepository<Login,Integer> {
	
	@Query("select l from Login l where username=:username and password=:password and status=1")
	public Optional<Login> getLogin(String username,String password);

	
	@Modifying
	@Query("update Login l set l.status=1 where l.loginid = :loginid")
	public int updateStatus(int loginid);
	
	@Modifying
	@Query("update Login l set l.status=2 where l.loginid = :loginid")
	public int reject(int loginid);
}
