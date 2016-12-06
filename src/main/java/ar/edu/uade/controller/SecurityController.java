package ar.edu.uade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accesoDenegado() {
		return "/views/accesoDenegado.html";
    }

}
