package ar.edu.uade.model;

import ar.edu.uade.dto.VacanteDTO;

public class Vacante {

	private float peso;
	private PreInscripcion preInscripcion;
	private Curso curso;
	private int prioridad;
	private boolean estadoAprobada;
	
	public Vacante(VacanteDTO dto) {
		
	}
	
	public int grabar() {
		return 0;
	}
	
	public void calcularPeso() {
		
	}
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public PreInscripcion getPreInscripcion() {
		return preInscripcion;
	}
	public void setPreInscripcion(PreInscripcion preInscripcion) {
		this.preInscripcion = preInscripcion;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public boolean isEstadoAprobada() {
		return estadoAprobada;
	}
	public void setEstadoAprobada(boolean estadoAprobada) {
		this.estadoAprobada = estadoAprobada;
	}
}
