package ar.edu.uade.dto;

public class DatosPadreDTO extends DatosExtraDTO {

	private String fichaMunicipal;
	private String nombre;
	
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
