package ar.edu.uade.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ar.edu.uade.dto.AspiranteDTO;

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
	
	public Aspirante() {
		
	}
	
	public Aspirante(AspiranteDTO dto) {
		
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
}
