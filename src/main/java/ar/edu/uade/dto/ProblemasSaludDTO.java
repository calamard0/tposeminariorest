package ar.edu.uade.dto;

public class ProblemasSaludDTO {

	private boolean fisicos;
	private boolean alergias;
	private boolean sensorial;
	private boolean epileptico;
	private boolean otros;
	private String otrosDescripcion;

	public boolean getFisicos() {
		return fisicos;
	}

	public void setFisicos(boolean fisicos) {
		this.fisicos = fisicos;
	}

	public boolean getAlergias() {
		return alergias;
	}

	public void setAlergias(boolean alergias) {
		this.alergias = alergias;
	}

	public boolean getSensorial() {
		return sensorial;
	}

	public void setSensorial(boolean sensorial) {
		this.sensorial = sensorial;
	}

	public boolean getEpileptico() {
		return epileptico;
	}

	public void setEpileptico(boolean epileptico) {
		this.epileptico = epileptico;
	}

	public boolean getOtros() {
		return otros;
	}

	public void setOtros(boolean otros) {
		this.otros = otros;
	}

	public String getOtrosDescripcion() {
		return otrosDescripcion;
	}

	public void setOtrosDescripcion(String otrosDescripcion) {
		this.otrosDescripcion = otrosDescripcion;
	}

}
