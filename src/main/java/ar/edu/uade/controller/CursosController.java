package ar.edu.uade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uade.model.Colegio;

@Controller
@RequestMapping("cursos")
public class CursosController {
	
	 @RequestMapping(value= "/view", method = RequestMethod.GET)
	 public ModelAndView viewCursos() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("cursos");
		 
//		 ColegioService colegioService = new ColegioService();
//		 Colegio colegio = colegioService.getColegio();
//		 mav.addObject("colegio", colegio);  
		 
		 return mav;
	 }
	 
	 @RequestMapping(value= "/update", method = RequestMethod.POST)
	 public ModelAndView updateCursos() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("cursos");
		 
//		 ColegioService colegioService = new ColegioService();
//		 Colegio colegio = colegioService.getColegio();
//		 mav.addObject("colegio", colegio);  
		 
		 return mav;
	 }
	 
	 
}
