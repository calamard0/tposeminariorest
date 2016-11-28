package ar.edu.uade.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uade.model.Colegio;
import ar.edu.uade.service.ColegioService;

@Controller
@RequestMapping("colegios")
public class ColegiosController {
	
	 @RequestMapping(value= "/view", method = RequestMethod.GET)
	 public ModelAndView viewColegios() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("colegios");
		 
		 ColegioService colegioService = new ColegioService();
		 List<Colegio> colegios = colegioService.getAllColegios();
		 mav.addObject("colegios", colegios);  
		 
		 return mav;
	 }
	 
	 @RequestMapping(value= "/create", method = RequestMethod.POST)
	 public void createColegio() {
		 ColegioService colegioService = new ColegioService();
		 colegioService.crear();
	 }
	 
	 @RequestMapping(value= "/update", method = RequestMethod.POST)
	 public void updateColegio() {
		 ColegioService colegioService = new ColegioService();
		 colegioService.update();
	 }
	 
	 @RequestMapping(value= "/delete", method = RequestMethod.GET)
	 public void deleteColegio() {
		 ColegioService colegioService = new ColegioService();
		 colegioService.update();
	 }
	 
	 @RequestMapping(value= "/cursos/view", method = RequestMethod.GET)
	 public ModelAndView viewCursos() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("vacantes");
		 
		 ColegioService colegioService = new ColegioService();
		 Colegio colegio = colegioService.getColegio();
		 
		 mav.addObject("colegio", colegio);
		 
		 return mav;
	 }
	 
}
