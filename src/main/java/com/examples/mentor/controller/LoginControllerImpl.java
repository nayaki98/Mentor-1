package com.examples.mentor.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
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
public class LoginControllerImpl {
	@Autowired
	private LoginService loginservice;
	
	@Autowired
	private UserService userervice;

	@RequestMapping(path = "/login")
	public String loginUser(Model model) throws Exception {
		Login login = new Login();
		model.addAttribute("login", login);
		return "login";
	}

	@RequestMapping(value = "/loginVerification", method = RequestMethod.GET)
	public ModelAndView userVerification(@ModelAttribute("login") @Valid Login login, BindingResult result,
			Model model,HttpSession session) {
		ModelAndView mav = null;
		if (result.hasErrors()) {

			mav = new ModelAndView("login");
		}

		String email = login.getEmail();
		List<Login> login1 = loginservice.findByemail(email);
		Login login2 = login1.get(0);
		if ((login.getEmail().equals(login2.getEmail())) && (login.getPassword().equals(login2.getPassword()))) {
			/*if(login.getRole().equals("user"))
			{
				Users user1=(Users) userervice.findByemail(email);
				session.setAttribute("user", user1);
				mav = new ModelAndView("searchMentorByTechnology");
			}
			else if(login.getRole().equals("mentor"))
			{
				session.setAttribute("mentor", login);
				mav = new ModelAndView("home");
			}*/
			mav = new ModelAndView("home");
			
		} else {
			login.setEmail(null);
			login.setPassword(null);
			mav = new ModelAndView("login","message","Invalid");
		}
		return mav;

	}

}
