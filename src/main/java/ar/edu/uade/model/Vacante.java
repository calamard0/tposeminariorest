package ar.edu.uade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ar.edu.uade.dto.VacanteDTO;

@Entity
public class Vacante {

	private int id;	
	private float peso;
	private int prioridad;
	private boolean estaAprobada;
	private PreInscripcion preinscripcion;
	private Curso curso;

	public Vacante() {
		
	}
	
	public Vacante(VacanteDTO dto) {
		
	}
	
	public void calcularPeso() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	public PreInscripcion getPreinscripcion() {
		return preinscripcion;
	}

	public void setPreinscripcion(PreInscripcion preinscripcion) {
		this.preinscripcion = preinscripcion;
	}

	@OneToOne
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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
