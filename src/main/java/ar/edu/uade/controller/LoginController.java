package ar.edu.uade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login")
public class LoginController {
	
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView viewLoginPage() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("login");		 
		 return mav;
	 }
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public ModelAndView login() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("colegios");		 
		 return mav;
	 }

}
