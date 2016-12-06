package ar.edu.uade.dto;

import java.util.Date;

public class HermanoEnColegioDTO {
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String tipoDocumento;
	private String numeroDocumento;
	private ColegioDTO colegio;

	public HermanoEnColegioDTO() {
		super();
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

	public void setFechaNacimiento(Date fechaNac) {
		this.fechaNacimiento = fechaNac;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public ColegioDTO getColegio() {
		return colegio;
	}

	public void setColegio(ColegioDTO colegio) {
		this.colegio = colegio;
	}
}
