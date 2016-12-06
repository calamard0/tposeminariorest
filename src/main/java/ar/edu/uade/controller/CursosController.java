package ar.edu.uade.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.uade.dao.ColegioRepository;
import ar.edu.uade.dao.UsuarioRepository;
import ar.edu.uade.dto.ColegioDTO;
import ar.edu.uade.dto.CursoDTO;
import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.Curso;
import ar.edu.uade.model.Usuario;

@Controller
@RequestMapping("cursos")
public class CursosController {
	
	@Autowired
	ColegioRepository colRepo;
	
	@Autowired
	UsuarioRepository usuarioRepo;
	
	@RequestMapping("/view")
    public String view(Model model) {
		model.addAttribute("colegioId", "123");
        return "/views/modificarColegio.html";
    }
	
	@RequestMapping("/currentuser")
	@ResponseBody
	public Usuario getColegioUsuarioLogueado() {
		Usuario usuario = null;
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = user.getUsername();
			usuario = usuarioRepo.findByNombreUsuario(username);
			usuario.getColegio().setCursos(null);			
		} catch (Exception e) {
			System.out.println("Usuario no logueado");
		}
		return usuario;
	}
		
	@RequestMapping(value= "/update", method = RequestMethod.POST)
	@ResponseBody
	public boolean updateCursos(@RequestBody ColegioDTO colegioDTO) {	
		 boolean updatedOk = false;
		 
		 try {
			 Colegio colegio = new Colegio(colegioDTO);
			 colRepo.save(colegio);
			 updatedOk = true;
		 } catch (Exception e) {
			 System.out.println(e.getMessage());
		 }
		 
		 return updatedOk;
	 }
	 
	 @RequestMapping(value= "/getCursoPorColegio/{colegioId}/{grado}")
	 @ResponseBody
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
	 @ResponseBody
	 public List<CursoDTO> getCursoPorColegio(@PathVariable Integer colegioId) {
		Colegio cole = colRepo.findOne(colegioId);
		List<CursoDTO> cursos = new ArrayList<CursoDTO>();
		
		for (Curso curso : cole.getCursos()) {
			cursos.add(curso.toDTO());
		}
		
		return cursos;
	 }
	 
	 @RequestMapping(value= "/getAlumnos/{colegioId}")
	 @ResponseBody
	 public List<CursoDTO> getAlumnos(@PathVariable Integer colegioId) {
		Colegio cole = colRepo.findOne(colegioId);
		List<CursoDTO> cursos = new ArrayList<CursoDTO>();
		
		for (Curso curso : cole.getCursos()) {
			cursos.add(curso.toDTO());
		}
		
		return cursos;
	 }
	 
}
