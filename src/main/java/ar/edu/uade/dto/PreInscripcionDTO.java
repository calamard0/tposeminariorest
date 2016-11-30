package ar.edu.uade.dto;

import java.util.Set;

import ar.edu.uade.model.Aspirante;
import ar.edu.uade.model.Curso;
import ar.edu.uade.model.DatosExtra;
import ar.edu.uade.model.Responsable;
import ar.edu.uade.model.Vacante;

public class PreInscripcionDTO {
	
	private int id;
	private Set<Vacante> vacantes;
	private Aspirante aspirante;
	private String estado;
	private Responsable responsable;
	private boolean validada;
	private DatosExtra datosExtra;
	private Curso curso;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Vacante> getVacantes() {
		return vacantes;
	}
	public void setVacantes(Set<Vacante> vacantes) {
		this.vacantes = vacantes;
	}
	public Aspirante getAspirante() {
		return aspirante;
	}
	public void setAspirante(Aspirante aspirante) {
		this.aspirante = aspirante;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Responsable getResponsable() {
		return responsable;
	}
	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
	public boolean isValidada() {
		return validada;
	}
	public void setValidada(boolean validada) {
		this.validada = validada;
	}
	public DatosExtra getDatosExtra() {
		return datosExtra;
	}
	public void setDatosExtra(DatosExtra datosExtra) {
		this.datosExtra = datosExtra;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
