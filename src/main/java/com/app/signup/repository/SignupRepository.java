package com.app.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.signup.model.User;


public interface SignupRepository extends JpaRepository<User, Integer>{
	
	public User findByEmail(String emailId);
	public User findByEmailAndPassword(String emailId,String password);

}
