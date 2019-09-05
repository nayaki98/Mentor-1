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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.examples.mentor.dao.MentorDao;
import com.examples.mentor.dao.UserDao;
import com.examples.mentor.model.Login;
import com.examples.mentor.model.Mentor;
import com.examples.mentor.model.Users;
import com.examples.mentor.service.LoginService;
import com.examples.mentor.service.MentorService;



@Controller
public class MentorControllerImpl {
	private String role="mentor";
	@Autowired
	private MentorService mentorservice;
	
	@Autowired
	private LoginService loginservice;
	
	@Autowired
	MentorDao mentorDao;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(path="/mentor")
	public String insert(Model model) throws Exception {
		Mentor mentor=new Mentor();
		model.addAttribute("mentor", mentor);
		return "mentorRegistration";
	}
	@RequestMapping(value = "/mentorRegistration", method = RequestMethod.GET)
	public String submit(@ModelAttribute("mentor") @Valid Mentor mentor, BindingResult result, Model model) {
		
		if(result.hasErrors()){
            
            return "mentorRegistration";
		}

		mentorservice.insertMentor(mentor);
		loginservice.insertLoginDetails(new Login(mentor.getEmail(),mentor.getPassword(),role));
		return "redirect:/mentorList";
	}

	@RequestMapping(path="/mentorList")
	public ModelAndView getmentorList() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("mentorList");
		mv.addObject("mentorList",mentorservice.getmentorList());
		return mv;
	}
	@RequestMapping(path="/searchMentorByTechnology")
	public String searchMentor(Model model) throws Exception {
		Mentor mentor=new Mentor();
		model.addAttribute("mentor", mentor);
		return "searchMentorTechnology";
	}
	
	@RequestMapping(value = "/getMentorsByTechnology", method = RequestMethod.GET)
	public ModelAndView getMentorsByTechnology(Mentor mentor) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("searchMentorListTechnology");
		mv.addObject("mentorList",mentorservice.findByTechnology(mentor.getTechnology()));
		return mv;
	}
	@RequestMapping(path="/searchMentorByTime")
	public String searchMentorByTime(Model model) throws Exception {
		Mentor mentor=new Mentor();
		model.addAttribute("mentor", mentor);
		return "searchMentorTime";
	}
	
	@RequestMapping(value = "/getMentorsByTime", method = RequestMethod.GET)
	public ModelAndView getMentorsByTime(Mentor mentor) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("searchMentorListTime");
		mv.addObject("mentorList",mentorservice.findByTime(mentor.getFromTime()));
		return mv;
	}

	@RequestMapping(path="/homePage")
	public String homePage(Model model) throws Exception {
		
		return "home";
	}
	
    @RequestMapping(path="/update")
    public ModelAndView updateStatus(@RequestParam("id") int id,@RequestParam("userId") int userId, Mentor mentor){
           ModelAndView mav=new ModelAndView();
           Mentor mentor1=mentorDao.findBymentorId(id);
           //mentorDao.save(mentor);
           System.out.println("hiii");
           Users user=userDao.findById(userId);
           
           user.setBlockStatus("RequestPending");
           mentor1.setStatus("RequestSent");
           mentorDao.save(mentor1);
           userDao.save(user);
           mav=new ModelAndView("redirect:/getMentorsByTechnology");
           return mav;
    }

}


/*@RequestMapping(path="/loginMentor")
public String loginUser(Model model) throws Exception {
	Mentor mentor=new Mentor();
	model.addAttribute("mentor", mentor);
	return "mentorlogin";
}
@RequestMapping(value = "/mentorVerification", method = RequestMethod.GET)
public ModelAndView mentorVerification(@ModelAttribute("mentor")  Mentor mentor) {
	 ModelAndView mav = null;
	 String email = mentor.getEmail();
	 List<Mentor> mentor1 = mentorservice.findByemail(email);
	 Mentor mentor2 = mentor1.get(0);
	 if ((mentor.getEmail().equals(mentor2.getEmail())) && (mentor.getPassword().equals(mentor2.getPassword()))) {
		 	mav = new ModelAndView("mentorRegistration");
  } 
	 else {
	  mentor.setEmail(null);
	  mentor.setPassword(null);
         mav = new ModelAndView("mentorlogin", "message", "Invalid Username or Password");
  }

  return mav;

}*/