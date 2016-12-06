package ar.edu.uade.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ar.edu.uade.dto.HermanoEnColegioDTO;

@Entity
@DiscriminatorValue( value="DH" )
public class DatosHermano extends DatosExtra {

	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String numeroDocumento;
	private String tipoDocumento;
	
	public DatosHermano() {
		
	}
	
	public DatosHermano(HermanoEnColegioDTO dto) {
		this.setColegio(new Colegio(dto.getColegio()));
		this.nombre = dto.getNombre();
		this.apellido = dto.getApellido();
		this.numeroDocumento = dto.getNumeroDocumento();
		this.fechaNacimiento = dto.getFechaNacimiento();
		this.tipoDocumento = dto.getTipoDocumento();
	}
	
	public HermanoEnColegioDTO toDTO() {
		HermanoEnColegioDTO dto = new HermanoEnColegioDTO();
		dto.setColegio(this.getColegio().toDTO());
		dto.setNombre(this.nombre);
		dto.setApellido(this.apellido);
		dto.setNumeroDocumento(this.numeroDocumento);
		dto.setFechaNacimiento(this.fechaNacimiento);
		dto.setTipoDocumento(this.tipoDocumento);
		return dto;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
}
