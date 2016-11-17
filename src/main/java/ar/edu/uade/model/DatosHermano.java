package ar.edu.uade.model;

import ar.edu.uade.dto.DatosHermanoDTO;

public class DatosHermano extends DatosExtra {

	private String nombre;
	private String apellido;
	private String dni;
	
	public DatosHermano(DatosHermanoDTO dto) {
		
	}
	
	public int grabar() {
		return 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
