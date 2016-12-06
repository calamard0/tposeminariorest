package ar.edu.uade.dto;

import java.util.Date;

public class AspiranteDTO {
	
	private int id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String sexo;
	private String tipoDocumento;
	private String numeroDocumento;
	private String paisNacimiento;
	private String sistemaSalud;
	private ProblemasSaludDTO problemasSalud;
	private boolean certificadoDisca;
	private String telefono;
	private DomicilioDTO domicilio;
	
	public AspiranteDTO() {
		
	}
	
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

	public DomicilioDTO getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}

	public ProblemasSaludDTO getProblemasSalud() {
		return problemasSalud;
	}

	public void setProblemasSalud(ProblemasSaludDTO problemasSalud) {
		this.problemasSalud = problemasSalud;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
