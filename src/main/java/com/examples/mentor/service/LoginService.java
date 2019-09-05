package com.examples.mentor.service;

import java.util.List;

import com.examples.mentor.model.Login;

public interface LoginService {

	

	void insertLoginDetails(Login login);

	List<Login> findByemail(String email);

}
