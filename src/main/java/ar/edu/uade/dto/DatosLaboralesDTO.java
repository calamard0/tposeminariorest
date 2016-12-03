package ar.edu.uade.dto;

import ar.edu.uade.model.Domicilio;

public class DatosLaboralesDTO {
	
	private int id;
	private String situacionLaboral;
	private String profesion;
	private boolean sostenFamiliar;
	private String telefono;
	private String datosReferencia;
	private DomicilioDTO domicilio;
	
	public DatosLaboralesDTO() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDatosReferencia() {
		return datosReferencia;
	}

	public void setDatosReferencia(String datosReferencia) {
		this.datosReferencia = datosReferencia;
	}

	public DomicilioDTO getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}

	public String getSituacionLaboral() {
		return situacionLaboral;
	}

	public void setSituacionLaboral(String situacionLaboral) {
		this.situacionLaboral = situacionLaboral;
	}

	public boolean isSostenFamiliar() {
		return sostenFamiliar;
	}

	public void setSostenFamiliar(boolean sostenFamiliar) {
		this.sostenFamiliar = sostenFamiliar;
	}

}
