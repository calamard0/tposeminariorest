package ar.edu.uade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.uade.dao.UsuarioRepository;
import ar.edu.uade.model.Usuario;

@Controller
public class SecurityController {
	
	@Autowired
	UsuarioRepository usuarioRepo;
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accesoDenegado() {
		return "/views/accesoDenegado.html";
    }

	@RequestMapping("/currentuser")
	@ResponseBody
	public Usuario getColegioUsuarioLogueado() {
		Usuario usuario = null;
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = user.getUsername();
			usuario = usuarioRepo.findByNombreUsuario(username);
			if (usuario.getColegio() != null) {
				usuario.getColegio().setCursos(null);			
			}
		} catch (Exception e) {
			usuario = new Usuario();
			usuario.setId(-1);
		}
		return usuario;
	}
	
}
