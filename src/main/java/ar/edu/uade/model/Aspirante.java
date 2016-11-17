package ar.edu.uade.model;

import java.util.List;

import ar.edu.uade.dto.AspiranteDTO;

public class Aspirante {

	private String nomobre;
	private String apellido;
	private String fechaNacimiento;
	private String sexo;
	private String tipoDocumento;
	private String nroDocumento;
	private String paisNacimiento;
	private String sistemaDeSalud;
	private List<String> problemasSalud;
	private boolean certificadoDiscapacidad;
	private Domicilio domicilio;
	
	public Aspirante(AspiranteDTO dto) {
		
	}
	
	public int grabar() {
		return 0;
	}
	
	public void modificar(AspiranteDTO dto) {
		
	}
	
	private Aspirante transformar(AspiranteDTO dto) {
		return null;
	}

	public String getNomobre() {
		return nomobre;
	}

	public void setNomobre(String nomobre) {
		this.nomobre = nomobre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
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

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getPaisNacimiento() {
		return paisNacimiento;
	}

	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}

	public String getSistemaDeSalud() {
		return sistemaDeSalud;
	}

	public void setSistemaDeSalud(String sistemaDeSalud) {
		this.sistemaDeSalud = sistemaDeSalud;
	}

	public List<String> getProblemasSalud() {
		return problemasSalud;
	}

	public void setProblemasSalud(List<String> problemasSalud) {
		this.problemasSalud = problemasSalud;
	}

	public boolean isCertificadoDiscapacidad() {
		return certificadoDiscapacidad;
	}

	public void setCertificadoDiscapacidad(boolean certificadoDiscapacidad) {
		this.certificadoDiscapacidad = certificadoDiscapacidad;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
}
