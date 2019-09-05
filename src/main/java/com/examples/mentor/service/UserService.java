package com.examples.mentor.service;




import java.util.List;

import com.examples.mentor.model.Users;

public interface UserService {

	public void insertUser(Users users);

	public List<Users> findByemail(String email);

	
	

}
