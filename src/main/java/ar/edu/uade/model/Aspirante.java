package ar.edu.uade.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ar.edu.uade.dto.AspiranteDTO;
import ar.edu.uade.dto.ProblemasSaludDTO;

@Entity
public class Aspirante {

	private int id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String sexo;
	private String tipoDocumento;
	private String numeroDocumento;
	private String paisNacimiento;
	private String sistemaSalud;
	private Set<ProblemaSalud> problemasSalud;
	private boolean certificadoDisca;
	private Domicilio domicilio;
	private String telefono;
	
	public Aspirante() {
		
	}
	
	public Aspirante(AspiranteDTO dto) {
		this.id = dto.getId();
		this.nombre = dto.getNombre();
		this.apellido = dto.getApellido();
		this.fechaNacimiento = dto.getFechaNacimiento();
		this.sexo = dto.getSexo();
		this.tipoDocumento = dto.getTipoDocumento();
		this.numeroDocumento = dto.getNumeroDocumento();
		this.paisNacimiento = dto.getPaisNacimiento();
		this.sistemaSalud = dto.getSistemaSalud();
		this.problemasSalud = this.armarListaProblemasSalud(dto.getProblemasSalud());
		this.certificadoDisca = dto.isCertificadoDisca();
		this.domicilio = new Domicilio(dto.getDomicilio());
		this.telefono = dto.getTelefono();
	}

	public AspiranteDTO toDTO() {
		AspiranteDTO dto = new AspiranteDTO();
		dto.setId(this.id);
		dto.setNombre(this.nombre);
		dto.setApellido(this.apellido);
		dto.setFechaNacimiento(this.fechaNacimiento);
		dto.setSexo(this.sexo);
		dto.setTipoDocumento(this.tipoDocumento);
		dto.setNumeroDocumento(this.numeroDocumento);
		dto.setPaisNacimiento(this.paisNacimiento);
		dto.setSistemaSalud(this.sistemaSalud);
		dto.setCertificadoDisca(this.certificadoDisca);
		dto.setDomicilio(this.domicilio.toDTO());
		dto.setProblemasSalud(this.armarProblemasSalud());
		dto.setTelefono(this.telefono);
		return dto;
	}

	private ProblemasSaludDTO armarProblemasSalud() {
		
		ProblemasSaludDTO dto = new ProblemasSaludDTO();
		if ( this.problemasSalud != null && this.problemasSalud.size() > 0 ) {
			
			for (ProblemaSalud ps : problemasSalud) {
				if ( ps.getDescripcion().equals(ProblemaSalud._alergia) ) 
					dto.setAlergias(true);
				if ( ps.getDescripcion().equals(ProblemaSalud._epileptico) ) 
					dto.setEpileptico(true);
				if ( ps.getDescripcion().equals(ProblemaSalud._fisico) ) 
					dto.setFisicos(true);
				if ( ps.getDescripcion().equals(ProblemaSalud._sensorial) ) 
					dto.setSensorial(true);
				if ( (! ps.getDescripcion().equals(ProblemaSalud._alergia)) && 
						(! ps.getDescripcion().equals(ProblemaSalud._epileptico)) && 
						(! ps.getDescripcion().equals(ProblemaSalud._fisico)) && 
						(! ps.getDescripcion().equals(ProblemaSalud._sensorial)) )   {
					dto.setOtros(true);
					dto.setOtrosDescripcion(ps.getDescripcion());
				}
			}
		}
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

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getSistemaSalud() {
		return sistemaSalud;
	}

	public void setSistemaSalud(String sistemaSalud) {
		this.sistemaSalud = sistemaSalud;
	}

	public boolean isCertificadoDisca() {
		return certificadoDisca;
	}

	public void setCertificadoDisca(boolean certificadoDisca) {
		this.certificadoDisca = certificadoDisca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getPaisNacimiento() {
		return paisNacimiento;
	}

	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}

	@OneToOne(cascade=CascadeType.ALL)
	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	@OneToMany(mappedBy = "aspirante", cascade = CascadeType.ALL)
	public Set<ProblemaSalud> getProblemasSalud() {
		return problemasSalud;
	}

	public void setProblemasSalud(Set<ProblemaSalud> problemasSalud) {
		this.problemasSalud = problemasSalud;
	}
	
	private Set<ProblemaSalud> armarListaProblemasSalud(ProblemasSaludDTO problemasSalud) {
		
		Set<ProblemaSalud> problemas = new HashSet<ProblemaSalud>();
		if ( problemasSalud != null ) {
			if (problemasSalud.getAlergias()) {
				ProblemaSalud ps = new ProblemaSalud();
				ps.setAspirante(this);
				ps.setDescripcion(ProblemaSalud._alergia);
				problemas.add(ps);
			}
				
			if (problemasSalud.getEpileptico()) {
				ProblemaSalud ps = new ProblemaSalud();
				ps.setAspirante(this);
				ps.setDescripcion(ProblemaSalud._epileptico);
				problemas.add(ps);
			}
			
			if (problemasSalud.getFisicos()) {
				ProblemaSalud ps = new ProblemaSalud();
				ps.setAspirante(this);
				ps.setDescripcion(ProblemaSalud._fisico);
				problemas.add(ps);
			}
			
			if (problemasSalud.getSensorial()) {
				ProblemaSalud ps = new ProblemaSalud();
				ps.setAspirante(this);
				ps.setDescripcion(ProblemaSalud._sensorial);
				problemas.add(ps);
			}
			
			if (problemasSalud.getOtros()) {
				ProblemaSalud ps = new ProblemaSalud();
				ps.setAspirante(this);
				ps.setDescripcion(problemasSalud.getOtrosDescripcion());
				problemas.add(ps);
			}
		}		
		return problemas;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
