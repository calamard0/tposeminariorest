package ar.edu.uade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("reportes")
public class ReporteController {
	
	 @RequestMapping(value= "/establecimiento", method = RequestMethod.GET)
	 public ModelAndView initPreinscripcion() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("reportecolegio");
		 
		 mav.addObject("reporte", null);  
		 
		 return mav;
	 }
	 
	 @RequestMapping(value= "/general", method = RequestMethod.GET)
	 public ModelAndView modificarPreinscripcion() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("reportegeneral");
		 
		 mav.addObject("reporte", null);  
		 
		 return mav;
	 }
	 
}
