package com.examples.mentor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.examples.mentor.model.Login;
import com.examples.mentor.model.Users;
import com.examples.mentor.service.LoginService;
import com.examples.mentor.service.UserService;

@Controller
public class UserControllerImpl {
	private String role="user";
	@Autowired
	private UserService userservice;
	
	@Autowired
	private LoginService loginservice;
	
	@RequestMapping(path="/user")
	public String insert(Model model) throws Exception {
		Users users=new Users();
		model.addAttribute("users", users);
		return "userRegistration";
	}
	@RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
	public String submit(@ModelAttribute("users") @Valid Users users, BindingResult result, Model model) {
		
		if(result.hasErrors()){
            
            return "userRegistration";
		}

		userservice.insertUser(users);
		loginservice.insertLoginDetails(new Login(users.getEmail(),users.getPassword(),role));
		return "redirect:/login";
	}
	/*@RequestMapping(path="/loginUser")
	public String loginUser(Model model) throws Exception {
		Users users=new Users();
		model.addAttribute("users", users);
		return "userlogin";
	}
	@RequestMapping(value = "/userVerification", method = RequestMethod.GET)
	public ModelAndView userVerification(@ModelAttribute("users")  Users users) {
		 ModelAndView mav = null;
		 String email = users.getEmail();
		 List<Users> user1 = userservice.findByemail(email);
		 Users user2 = user1.get(0);
		 if ((users.getEmail().equals(user2.getEmail())) && (users.getPassword().equals(user2.getPassword()))) {
	         mav = new ModelAndView("userRegistration");
	  }
		 else {
		  users.setEmail(null);
		  users.setPassword(null);
	         mav = new ModelAndView("userlogin", "message", "Invalid Username or Password");
	  }

	  return mav;

	}*/
}
