package ar.edu.uade.model;

import ar.edu.uade.dto.UsuarioDTO;

public class Usuario {

	private String nombreUsuario;
	private String password;
	private Colegio colegio;
	private String rol;
	
	public Usuario(UsuarioDTO dto) {
		
	}
	
	public int grabar() {
		return 0;
	}
	
	public void modificar() {
		
	}
	
	public void eliminar() {
		
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Colegio getColegio() {
		return colegio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
