package ar.edu.uade.dao;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uade.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	public Usuario findByNombreUsuario(String nombre);
	
}
