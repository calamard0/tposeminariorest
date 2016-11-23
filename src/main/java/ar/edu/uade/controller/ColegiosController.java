package ar.edu.uade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uade.dto.ColegioDTO;

@Controller
@RequestMapping("colegios")
public class ColegiosController {
	
	 @RequestMapping(value= "/view", method = RequestMethod.GET)
	 public ModelAndView view() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("colegios"); //NOMBRE DEL HTML QUE VA A USAR
		 
		 
		 ColegioDTO dto = new ColegioDTO();
		 mav.addObject("colegios", dto);  //OBJETOS QUE QUEREMOS PASARLE A LA VISTA
		 
		 return mav;
	 }
	 
}
