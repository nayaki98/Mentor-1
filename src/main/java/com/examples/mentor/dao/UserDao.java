package com.examples.mentor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examples.mentor.model.Users;

public interface UserDao extends JpaRepository<Users, Integer> {


	List<Users> findByemail(String email);
	
	Users findById(int userId);
}
