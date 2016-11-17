package ar.edu.uade.model;

import ar.edu.uade.dto.DatosPadreDTO;

public class DatosPadre extends DatosExtra {

	private String fichaMunicipal;
	private String nombre;
	
	public DatosPadre(DatosPadreDTO dto) {
		
	}
	
	public int grabar() {
		return 0;
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
