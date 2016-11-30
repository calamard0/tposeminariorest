package ar.edu.uade.dto;

public class VacanteDTO {

	private int id;	
	private float peso;
	private int prioridad;
	private boolean estaAprobada;

	public VacanteDTO() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public boolean isEstaAprobada() {
		return estaAprobada;
	}

	public void setEstaAprobada(boolean estaAprobada) {
		this.estaAprobada = estaAprobada;
	}
	
}
