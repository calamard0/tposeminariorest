package ar.edu.uade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.uade.dao.UsuarioRepository;
import ar.edu.uade.model.Usuario;

@Controller
public class UserController {
	
	@Autowired
	UsuarioRepository usuarioRepo;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
		
		Usuario usuario = getUsuarioLogueado();
		if (usuario != null) {
			if(usuario.getRol().equals("ADMIN")) {
				return "redirect:/preinscripcion/control";
			} else if (usuario.getRol().equals("COLEGIO")) {
				return "redirect:/cursos/view";
			}
		}

        return "/views/login.html";
    }
	
	private Usuario getUsuarioLogueado() {
		Usuario usuario = null;
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = user.getUsername();
			usuario = usuarioRepo.findByNombreUsuario(username);
			if (usuario.getColegio() != null) {
				usuario.getColegio().setCursos(null);			
			}
		} catch (Exception e) {
			return null;
		}
		return usuario;
	}
	
}
