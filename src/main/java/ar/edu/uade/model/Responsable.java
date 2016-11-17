package ar.edu.uade.model;

import ar.edu.uade.dto.ResponsableDTO;

public class Responsable {

	private String nomobre;
	private String apellido;
	private String tipoDocumento;
	private String nroDocumento;
	private String vinculoAspirante;
	private String nacionalidad;
	private String email;
	private String telefonoParticular;
	private String telefonoAlternativ;
	private DatosLaborales datosLaborales;
	
	public Responsable(ResponsableDTO dto) {
		
	}
	
	public int grabar() {
		return 0;
	}

	public String getNomobre() {
		return nomobre;
	}

	public void setNomobre(String nomobre) {
		this.nomobre = nomobre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getVinculoAspirante() {
		return vinculoAspirante;
	}

	public void setVinculoAspirante(String vinculoAspirante) {
		this.vinculoAspirante = vinculoAspirante;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonoParticular() {
		return telefonoParticular;
	}

	public void setTelefonoParticular(String telefonoParticular) {
		this.telefonoParticular = telefonoParticular;
	}

	public String getTelefonoAlternativ() {
		return telefonoAlternativ;
	}

	public void setTelefonoAlternativ(String telefonoAlternativ) {
		this.telefonoAlternativ = telefonoAlternativ;
	}

	public DatosLaborales getDatosLaborales() {
		return datosLaborales;
	}

	public void setDatosLaborales(DatosLaborales datosLaborales) {
		this.datosLaborales = datosLaborales;
	}
}
