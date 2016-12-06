package ar.edu.uade.dto;

import java.util.Date;

public class AlumnoDTO {

	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private boolean tieneHermano;
	private boolean padreEmpleado;
	private boolean vieneJardin;
	
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
	public boolean isTieneHermano() {
		return tieneHermano;
	}
	public void setTieneHermano(boolean tieneHermano) {
		this.tieneHermano = tieneHermano;
	}
	public boolean isPadreEmpleado() {
		return padreEmpleado;
	}
	public void setPadreEmpleado(boolean padreEmpleado) {
		this.padreEmpleado = padreEmpleado;
	}
	public boolean isVieneJardin() {
		return vieneJardin;
	}
	public void setVieneJardin(boolean vieneJardin) {
		this.vieneJardin = vieneJardin;
	}
}
