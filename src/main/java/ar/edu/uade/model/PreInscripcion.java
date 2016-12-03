package ar.edu.uade.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ar.edu.uade.dto.DatosColegioAntDTO;
import ar.edu.uade.dto.DatosHermanoDTO;
import ar.edu.uade.dto.DatosPadreDTO;
import ar.edu.uade.dto.PreInscripcionDTO;
import ar.edu.uade.helper.CalcularPesosHelper;

import ar.edu.uade.dto.VacanteDTO;

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
		this.id= dto.getId();
		this.aspirante = new Aspirante(dto.getAspirante());
		this.estado = dto.getEstado();
		this.responsable = new Responsable(dto.getResponsable());
		this.validada = dto.isValidada();
		//this.datosExtra =
		this.curso = new Curso(dto.getCurso());
		this.vacantes = new HashSet<Vacante>();
		for (VacanteDTO vacDto : dto.getVacantes()) {
			this.vacantes.add(new Vacante(vacDto));
		}
		
		if (dto.getDatosExtra() instanceof DatosHermanoDTO )
			this.datosExtra = new DatosHermano((DatosHermanoDTO) dto.getDatosExtra());
		
		if (dto.getDatosExtra() instanceof DatosPadreDTO )
			this.datosExtra = new DatosPadre((DatosPadreDTO) dto.getDatosExtra());
		
		if (dto.getDatosExtra() instanceof DatosColegioAntDTO )
			this.datosExtra = new DatosColegioAnt((DatosColegioAntDTO) dto.getDatosExtra());
	}
	
	public PreInscripcionDTO toDTO() {
		PreInscripcionDTO dto = new PreInscripcionDTO();
		dto.setId(this.id);
		dto.setAspirante(this.aspirante.toDTO());
		dto.setEstado(this.estado);
		dto.setResponsable(this.responsable.toDTO());
		dto.setValidada(this.validada);
		dto.setCurso(this.curso.toDTO());
		dto.setVacantes(new HashSet<VacanteDTO>());
		for (Vacante vac : this.vacantes) {
			dto.getVacantes().add(vac.toDTO());
		}
		
		if (this.datosExtra instanceof DatosHermano )
			dto.setDatosExtra(((DatosHermano)this.datosExtra).toDTO());
		
		if (this.datosExtra instanceof DatosPadre )
			dto.setDatosExtra(((DatosPadre)this.datosExtra).toDTO());
		
		if (this.datosExtra instanceof DatosColegioAnt )
			dto.setDatosExtra(((DatosColegioAnt)this.datosExtra).toDTO());
		
		return dto;
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
		for(Vacante vac : vacantes){
			vac.setPeso(CalcularPesosHelper.calcularPesopeso(vac, this.datosExtra,this.aspirante, this.responsable));
		}
		
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
