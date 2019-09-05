package com.examples.mentor.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.mentor.dao.LoginDao;
import com.examples.mentor.model.Login;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao logindao;

	@Override
	public void insertLoginDetails(Login login) {
		logindao.save(login);
		
	}

	@Override
	public List<Login> findByemail(String email) {
		
		return logindao.findByemail(email);
	}

	

}
