package com.examples.mentor.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="mentor")
public class Mentor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mentorid")	
	private int mentorId;

	@NotEmpty(message="please enter username")
	@Column(name="mentorname")
	private String mentorName;

	@NotEmpty(message="please enter password")
	@Column(name="password")
	private String password;
	
	@NotEmpty(message="please enter valid emailID")
	@Column(name="email")
	private String email;

	@NotEmpty(message="please enter mobileNumber")
	@Column(name="mobilenumber")
	private String mobileNumber;
	
	
	@Column(name="year_of_experience")
	private int yearOfExperience;
	
	@NotEmpty(message="please enter technologies known")
	@Column(name="technology_known")
	private String technology;
	
	
	@Column(name="numberOfTrainingCompleted")
	private int numberOfTrainingCompleted;
	
	@NotEmpty(message="please enter year of linkedInURL")
	@Column(name="linked_in_url")
	private String linkedInURL;
	
	@Column(name="fromDate")
	private Date fromDate;
	
	@Column(name="toDate")
	private Date toDate;
	
	@Column(name="fromTime")
	private String fromTime;
	
	@Column(name="toTime")
	private String toTime;
	
	@Column(name="status")
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMentorId() {
		return mentorId;
	}

	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	

	public int getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public int getNumberOfTrainingCompleted() {
		return numberOfTrainingCompleted;
	}

	public void setNumberOfTrainingCompleted(int numberOfTrainingCompleted) {
		this.numberOfTrainingCompleted = numberOfTrainingCompleted;
	}

	public String getLinkedInURL() {
		return linkedInURL;
	}

	public void setLinkedInURL(String linkedInURL) {
		this.linkedInURL = linkedInURL;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	
}
