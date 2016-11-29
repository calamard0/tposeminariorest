package ar.edu.uade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.uade.dto.VacanteDTO;

@Entity
public class Vacante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codVacantes;
	
	private float peso;
	private int prioridad;
	private boolean estaAprobada;
	
	/*
	 * Ver estos dos campos como hacerlos para relacionar
	 */
	//private PreInscripcion preInscripcion;
	//private Curso curso;

	
	public Vacante(VacanteDTO dto) {
		
	}
	
	public int grabar() {
		return 0;
	}
	
	public void calcularPeso() {
		
	}

	public int getCodVacantes() {
		return codVacantes;
	}

	public void setCodVacantes(int codVacantes) {
		this.codVacantes = codVacantes;
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

//	public PreInscripcion getPreInscripcion() {
//		return preInscripcion;
//	}
//
//	public void setPreInscripcion(PreInscripcion preInscripcion) {
//		this.preInscripcion = preInscripcion;
//	}
//
//	public Curso getCurso() {
//		return curso;
//	}
//
//	public void setCurso(Curso curso) {
//		this.curso = curso;
//	}
}
