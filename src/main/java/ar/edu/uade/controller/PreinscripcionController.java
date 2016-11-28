package ar.edu.uade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uade.dto.PreInscripcionDTO;

@Controller
@RequestMapping("preinscripcion")
public class PreinscripcionController {
	
	 @RequestMapping(value= "/nueva", method = RequestMethod.GET)
	 public ModelAndView initPreinscripcion() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("preinscripcion");
		 
		 mav.addObject("colegio", null);  
		 
		 return mav;
	 }
	 
	 @RequestMapping(value= "/crear", method = RequestMethod.POST)
	 public ModelAndView crearPreinscripcion(@RequestBody PreInscripcionDTO preInscripcionDTO) {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("preinscripcion");
		 
		 mav.addObject("colegio", null);  
		 
		 return mav;
	 }
	 
	 @RequestMapping(value= "/modificar", method = RequestMethod.POST)
	 public ModelAndView modificarPreinscripcion() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("preinscripcion");
		 
		 mav.addObject("colegio", null);  
		 
		 return mav;
	 }
	 
	 
	 @RequestMapping(value= "/validar", method = RequestMethod.GET)
	 public ModelAndView validarPreinscripcion() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("preinscripcion");
		 
		 mav.addObject("colegio", null);  
		 
		 return mav;
	 }
	 
	 
}
