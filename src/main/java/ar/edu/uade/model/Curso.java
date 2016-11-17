package ar.edu.uade.model;

import java.util.SortedSet;

import ar.edu.uade.dto.CursoDTO;

public class Curso {

	private int codigo;
	private int vacantesDisponibles;
	private SortedSet<Vacante> vacantes;
	private String descripcion;
	private int grado;
	
	public Curso(CursoDTO dtro) {
	}
	
	public int grabar() {
		return 0;
	}
	
	public void modificar() {
		
	}
	
	public void eliminar() {
		
	}
	
	private Curso transformar(CursoDTO dto) {
		return null;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getVacantesDisponibles() {
		return vacantesDisponibles;
	}
	public void setVacantesDisponibles(int vacantesDisponibles) {
		this.vacantesDisponibles = vacantesDisponibles;
	}
	public SortedSet<Vacante> getVacantes() {
		return vacantes;
	}
	public void setVacantes(SortedSet<Vacante> vacantes) {
		this.vacantes = vacantes;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getGrado() {
		return grado;
	}
	public void setGrado(int grado) {
		this.grado = grado;
	}
}
