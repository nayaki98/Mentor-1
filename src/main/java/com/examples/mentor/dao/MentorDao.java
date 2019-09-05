package com.examples.mentor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examples.mentor.model.Mentor;



public interface MentorDao  extends JpaRepository<Mentor, Integer>{

	List<Mentor> findByemail(String email);

	List<Mentor> findBytechnology(String technology);

	List<Mentor> findByfromTime(String fromTime);

	Mentor findBymentorId(int id);

}
