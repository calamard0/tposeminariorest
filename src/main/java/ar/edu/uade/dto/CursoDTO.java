package ar.edu.uade.dto;

public class CursoDTO {

	private String descripcion;
	private int grado;
	private int vacantesDisponibles;
//	private ColegioDTO colegio;

	public CursoDTO( String descripcion, int grado, int vacantesDisponibles ) {
		this.descripcion = descripcion;
		this.grado = grado;
		this.vacantesDisponibles = vacantesDisponibles;
	}
	
//	public CursoDTO( String descripcion, int grado, int vacantesDisponibles, ColegioDTO dtoColegio ) {
//		this.descripcion = descripcion;
//		this.grado = grado;
//		this.vacantesDisponibles = vacantesDisponibles;
//		this.colegio = dtoColegio;
//	}
	
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
//	public ColegioDTO getColegio() {
//		return colegio;
//	}
//	public void setColegio(ColegioDTO colegio) {
//		this.colegio = colegio;
//	}
}
