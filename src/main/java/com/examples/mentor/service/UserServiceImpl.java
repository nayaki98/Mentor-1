package com.examples.mentor.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.mentor.dao.UserDao;
import com.examples.mentor.model.Users;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userdao;

	
	public void insertUser(Users users) {
		userdao.save(users);
		
	}


	public List<Users> findByemail(String email) {
		// TODO Auto-generated method stub
		return userdao.findByemail(email);
	}


	

}
