package com.examples.mentor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="login_table")
public class Login {
	
	@Id
	@NotEmpty(message="please enter Email")
	@Column(name="email")
	private String email;
	
	@NotEmpty(message="please enter password")
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;

	public Login()
	{
		
	}
	
	public Login(String email,String password, String role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

}
