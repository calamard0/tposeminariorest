package ar.edu.uade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uade.dao.PreInscripcionRepository;
import ar.edu.uade.dto.PreInscripcionDTO;
import ar.edu.uade.model.PreInscripcion;

@Controller
@RequestMapping("preinscripcion")
public class PreinscripcionController {
	
	 @Autowired
	 PreInscripcionRepository preRepo;
	
	 @RequestMapping(value= "/nueva", method = RequestMethod.GET)
	 public ModelAndView initPreinscripcion() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("preinscripcion");
		 
		 mav.addObject("colegio", null);  
		 
		 return mav;
	 }
	 
	 @RequestMapping(value= "/crear", method = RequestMethod.POST)
	 public ModelAndView crearPreinscripcion(@RequestBody PreInscripcionDTO dto) {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("preinscripcion");
		 
		 PreInscripcion preInscripcion = new PreInscripcion(dto);
		 preRepo.save(new PreInscripcion(dto));
		 
		 mav.addObject("preInscripcion", preInscripcion);  
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
