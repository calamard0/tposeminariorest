package ar.edu.uade.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ar.edu.uade.dto.DatosHermanoDTO;

@Entity
@DiscriminatorValue( value="DH" )
public class DatosHermano extends DatosExtra {

	private String nombre;
	private String apellido;
	private String numeroDocumento;
	
	public DatosHermano() {
		
	}
	
	public DatosHermano(DatosHermanoDTO dto) {
		
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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
}
