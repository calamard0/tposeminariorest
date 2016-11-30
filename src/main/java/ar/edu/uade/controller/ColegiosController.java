package ar.edu.uade.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uade.dao.ColegioRepository;
import ar.edu.uade.dto.ColegioDTO;
import ar.edu.uade.model.Colegio;
import ar.edu.uade.service.ColegioService;

@RestController
@RequestMapping("colegios")
public class ColegiosController {
	
	@Autowired
	ColegioRepository colRepo;
	
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
	 
	 @RequestMapping(value= "/getColegioByNombre/{nombre}")
	 public List<ColegioDTO> getColegioPorNombre(@PathVariable String nombre) {
		 List<Colegio> colegios = colRepo.findByNombre(nombre);
		 
		 List<ColegioDTO> dtos = new ArrayList<ColegioDTO>();
		 for (Colegio colegio : colegios) {
			dtos.add(colegio.toDTO());
		}
		return dtos;
	 }
	 
}
