package com.examples.mentor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examples.mentor.model.Login;
import com.examples.mentor.model.Mentor;



public interface LoginDao  extends JpaRepository<Login, String>{

	void save(Mentor mentor);

	List<Login> findByemail(String email);

}
