package ar.edu.uade.model;

import java.util.ArrayList;
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

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.uade.dao.CursoRepository;
import ar.edu.uade.dto.AlumnoDTO;
import ar.edu.uade.dto.CursoDTO;
import ar.edu.uade.dto.PreInscripcionDTO;
import ar.edu.uade.helper.CalcularPesosHelper;

@Entity
@Table(name = "preinscripcion")
public class PreInscripcion {

	@Autowired
	CursoRepository cursoRepo;
	
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
		
		if (dto.getDatosExtra().getJardinAnterior() != null) {
			this.datosExtra = new DatosColegioAnt(dto.getDatosExtra().getJardinAnterior());
		}
		
		if (dto.getDatosExtra().getHermanoEnColegio() != null) {
			this.datosExtra = new DatosHermano(dto.getDatosExtra().getHermanoEnColegio());
		}

		if (dto.getDatosExtra().getResponsableEnColegio() != null) {
			this.datosExtra = new DatosPadre(dto.getDatosExtra().getResponsableEnColegio());
		}
		
		this.vacantes = new HashSet<Vacante>();
		int i = 8;
		for (CursoDTO curDto : dto.getCursos()) {
			Vacante vac = new Vacante();
			vac.setCurso(new Curso(curDto));
			vac.setEstaAprobada(false);
			vac.setPeso(0);
			vac.setPrioridad(i);
			vac.setPreinscripcion(this);
			this.vacantes.add(vac);
			i -= 1;
		}
	}
	
	public PreInscripcionDTO toDTO() {
		PreInscripcionDTO dto = new PreInscripcionDTO();
		dto.setId(this.id);
		dto.setAspirante(this.aspirante.toDTO());
		dto.setEstado(this.estado);
		dto.setResponsable(this.responsable.toDTO());
		dto.setValidada(this.validada);
		dto.setCursos(new ArrayList<CursoDTO>());
		for (Vacante vac : this.vacantes) {
			dto.getCursos().add(vac.getCurso().toDTO());
		}
		
		return dto;
	}
	
	public AlumnoDTO toAlumnoDTO() {
		AlumnoDTO dto = new AlumnoDTO();
		dto.setApellido(this.aspirante.getApellido());
		dto.setFechaNacimiento(this.aspirante.getFechaNacimiento());
		dto.setNombre(this.aspirante.getNombre());
		
		if ( this.datosExtra instanceof DatosPadre )
			dto.setPadreEmpleado(true);
		if ( this.datosExtra instanceof DatosHermano )
			dto.setTieneHermano(true);
		if ( this.datosExtra instanceof DatosColegioAnt )
			dto.setVieneJardin(true);
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
