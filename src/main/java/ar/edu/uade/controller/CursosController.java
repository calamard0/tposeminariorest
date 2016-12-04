package ar.edu.uade.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uade.dao.ColegioRepository;
import ar.edu.uade.dto.CursoDTO;
import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.Curso;

@RestController
@RequestMapping("cursos")
public class CursosController {
	
	@Autowired
	ColegioRepository colRepo;
	
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
	 
	 @RequestMapping(value= "/getCursoPorColegio/{colegioId}/{grado}")
	 public CursoDTO getCursoPorColegio(@PathVariable Integer colegioId, @PathVariable Integer grado) {
		 Colegio cole = colRepo.findOne(colegioId);
		 Curso cursoEncontrado = null;
		 for (Curso cur : cole.getCursos()) {
			if ( cur.getGrado() == grado ) {
				cursoEncontrado = cur;
				break;
			}		
		}
		return cursoEncontrado.toDTO();
	 }
	 
	 @RequestMapping(value= "/getCursos/{colegioId}")
	 public List<CursoDTO> getCursoPorColegio(@PathVariable Integer colegioId) {
		Colegio cole = colRepo.findOne(colegioId);
		List<CursoDTO> cursos = new ArrayList<CursoDTO>();
		
		for (Curso curso : cole.getCursos()) {
			cursos.add(curso.toDTO());
		}
		
		return cursos;
	 }
	 
	 
	 
}
