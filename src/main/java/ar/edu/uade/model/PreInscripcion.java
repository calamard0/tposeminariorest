package ar.edu.uade.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ar.edu.uade.dto.PreInscripcionDTO;

@Entity
@Table(name = "preinscripcion")
public class PreInscripcion {

	
	private int id;
	private Set<Vacante> vacantes;
	private Aspirante aspirante;
	private String estado;
	private Responsable responsable;
	private boolean validada;
	private DatosExtra datosExtra;
	private Curso curso;
	
	public PreInscripcion() {
		
	}
	
	public PreInscripcion(PreInscripcionDTO dto) {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@OneToOne(cascade=CascadeType.ALL)
	public Aspirante getAspirante() {
		return aspirante;
	}

	public void setAspirante(Aspirante aspirante) {
		this.aspirante = aspirante;
	}

	@OneToOne(cascade=CascadeType.ALL)
	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@OneToOne
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@OneToOne(cascade=CascadeType.ALL)
	public DatosExtra getDatosExtra() {
		return datosExtra;
	}

	public void setDatosExtra(DatosExtra datosExtra) {
		this.datosExtra = datosExtra;
	}

	@OneToMany(mappedBy = "preinscripcion", cascade = CascadeType.ALL)
	public Set<Vacante> getVacantes() {
		return vacantes;
	}

	public void setVacantes(Set<Vacante> vacantes) {
		this.vacantes = vacantes;
	}

	public boolean isValidada() {
		return validada;
	}

	public void setValidada(boolean validada) {
		this.validada = validada;
	}
}
