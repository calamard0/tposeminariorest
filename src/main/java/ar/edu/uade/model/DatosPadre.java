package ar.edu.uade.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ar.edu.uade.dto.DatosPadreDTO;

@Entity
@DiscriminatorValue( value="DP" )
public class DatosPadre extends DatosExtra {

	private String fichaMunicipal;
	private String nombre;
	
	public DatosPadre() {
		
	}
	
	public DatosPadre(DatosPadreDTO dto) {
		
	}

	public String getFichaMunicipal() {
		return fichaMunicipal;
	}

	public void setFichaMunicipal(String fichaMunicipal) {
		this.fichaMunicipal = fichaMunicipal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
