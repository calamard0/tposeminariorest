package ar.edu.uade.model;

import java.util.List;
import java.util.SortedSet;

import ar.edu.uade.dto.PreInscripcionDTO;

public class PreInscripcion {

	private int codigo;
	private SortedSet<Vacante> vacantes;
	private Aspirante aspirante;
	private List<EstadoPreInscripcion> estados;
	private Responsable responsable;
	private boolean validada;
	private DatosExtra datosExtra;
	
	public PreInscripcion(PreInscripcionDTO dto) {
		
	}
	
	public boolean tieneVacanteAsignada() {
		return true;
	}
	
	public void modificar(PreInscripcionDTO dto) {
		
	}
	
	public int grabar() {
		return 0;
	}
	
	public void validar() {
		
	}
	
	public void calcularPesoVacantes() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public SortedSet<Vacante> getVacantes() {
		return vacantes;
	}

	public void setVacantes(SortedSet<Vacante> vacantes) {
		this.vacantes = vacantes;
	}

	public Aspirante getAspirante() {
		return aspirante;
	}

	public void setAspirante(Aspirante aspirante) {
		this.aspirante = aspirante;
	}

	public List<EstadoPreInscripcion> getEstados() {
		return estados;
	}

	public void setEstados(List<EstadoPreInscripcion> estados) {
		this.estados = estados;
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
}
