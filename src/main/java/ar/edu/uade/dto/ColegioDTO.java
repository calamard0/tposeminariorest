package ar.edu.uade.dto;

import java.util.Set;

public class ColegioDTO {
	
	private int id;
	public String nombre;
	public String direccion;
	public Set<CursoDTO> cursos;
	
	public ColegioDTO() {
	}
	
	public ColegioDTO(String nombre, String direccion, Set<CursoDTO> cursos) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.cursos = cursos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<CursoDTO> getCursos() {
		return cursos;
	}

	public void setCursos(Set<CursoDTO> cursos) {
		this.cursos = cursos;
	}
	
}
