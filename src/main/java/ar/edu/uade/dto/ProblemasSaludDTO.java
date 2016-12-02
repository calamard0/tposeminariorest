package ar.edu.uade.dto;

public class ProblemasSaludDTO {

	private Boolean fisicos;
	private Boolean alergias;
	private Boolean sensorial;
	private Boolean epileptico;
	private Boolean otros;
	private String otrosDescripcion;

	public Boolean getFisicos() {
		return fisicos;
	}

	public void setFisicos(Boolean fisicos) {
		this.fisicos = fisicos;
	}

	public Boolean getAlergias() {
		return alergias;
	}

	public void setAlergias(Boolean alergias) {
		this.alergias = alergias;
	}

	public Boolean getSensorial() {
		return sensorial;
	}

	public void setSensorial(Boolean sensorial) {
		this.sensorial = sensorial;
	}

	public Boolean getEpileptico() {
		return epileptico;
	}

	public void setEpileptico(Boolean epileptico) {
		this.epileptico = epileptico;
	}

	public Boolean getOtros() {
		return otros;
	}

	public void setOtros(Boolean otros) {
		this.otros = otros;
	}

	public String getOtrosDescripcion() {
		return otrosDescripcion;
	}

	public void setOtrosDescripcion(String otrosDescripcion) {
		this.otrosDescripcion = otrosDescripcion;
	}

}
