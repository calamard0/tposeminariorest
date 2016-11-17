package ar.edu.uade.model;

import java.util.List;

import ar.edu.uade.dto.ColegioDTO;

public class Colegio {

	private int codigo;
	private String nombre;
	private String direccion;
	private List<Curso> cursos;
	
	public Colegio(ColegioDTO colegio) {
		
	}
	
	public int grabar() {
		return 0;
	}
	
	public void modificar() {
		
	}
	
	public void eliminar() {
		
	}
	
	public void modificarVacantes(ColegioDTO dto) {
		
	}
	
	private void addCurso(int vacantesDisponibles, String descripcion, int grado) {
		
	}
	
	private Curso buscarCursoPorCodigo(int codigo) {
		return null;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}
