package ar.edu.uade.dto;

import java.util.List;

public class CursoDTO {

	private int id;
	private String descripcion;
	private int grado;
	private int vacantesDisponibles;
	private ColegioDTO colegio;
	private List<AlumnoDTO> alumnos;

	public CursoDTO() {

	}

	public CursoDTO(String descripcion, int grado, int vacantesDisponibles) {
		this.descripcion = descripcion;
		this.grado = grado;
		this.vacantesDisponibles = vacantesDisponibles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getVacantesDisponibles() {
		return vacantesDisponibles;
	}

	public void setVacantesDisponibles(int vacantesDisponibles) {
		this.vacantesDisponibles = vacantesDisponibles;
	}
	
	public ColegioDTO getColegio() {
		return colegio;
	}
	 
	public void setColegio(ColegioDTO colegio) {
		this.colegio = colegio;
	}

	public List<AlumnoDTO> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<AlumnoDTO> alumnos) {
		this.alumnos = alumnos;
	}
}
