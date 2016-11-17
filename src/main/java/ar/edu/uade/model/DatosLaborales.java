package ar.edu.uade.model;

import ar.edu.uade.dto.DatosLaboralesDTO;

public class DatosLaborales {

	private String situacionLaboral;
	private String profesion;
	private boolean sostenFamiliar;
	private String telefono;
	private String datosReferencia;
	private Domicilio domicilio;
	
	public DatosLaborales(DatosLaboralesDTO dto) {
		
	}
	
	public int grabar() {
		return 0;
	}

	public String getSituacionLaboral() {
		return situacionLaboral;
	}

	public void setSituacionLaboral(String situacionLaboral) {
		this.situacionLaboral = situacionLaboral;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public boolean isSostenFamiliar() {
		return sostenFamiliar;
	}

	public void setSostenFamiliar(boolean sostenFamiliar) {
		this.sostenFamiliar = sostenFamiliar;
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

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
}
