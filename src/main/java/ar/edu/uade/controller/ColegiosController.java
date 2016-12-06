package ar.edu.uade.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uade.dao.ColegioRepository;
import ar.edu.uade.dto.ColegioDTO;
import ar.edu.uade.model.Colegio;

@Controller
@RequestMapping("colegios")
public class ColegiosController {
	
	@Autowired
	ColegioRepository colRepo;
	
	 @RequestMapping(value= "/view", method = RequestMethod.GET)
	 public ModelAndView viewColegios() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("colegios.html");
		 
		 
		 return mav;
	 }
	 
	 @RequestMapping(value= "/create", method = RequestMethod.POST)
	 public void createColegio(ColegioDTO dto) {
		 Colegio col = new Colegio(dto);
		 colRepo.save(col);
	 }
	 
	 @RequestMapping(value= "/getColegioByNombre/{nombre}")
	 @ResponseBody
	 public List<ColegioDTO> getColegioPorNombre(@PathVariable String nombre) {
		 List<Colegio> colegios = colRepo.findByNombre(nombre);
		 
		 List<ColegioDTO> dtos = new ArrayList<ColegioDTO>();
		 for (Colegio colegio : colegios) {
			dtos.add(colegio.toDTO());
		}
		return dtos;
	 }
	 
	 @RequestMapping(value= "/getById/{colegioId}")
	 @ResponseBody
	 public ColegioDTO getById(@PathVariable Integer colegioId) {
		Colegio cole = colRepo.findOne(colegioId);
		return cole.toDTO();
	 }
	 
}
