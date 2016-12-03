package ar.edu.uade.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ar.edu.uade.dto.DatosHermanoDTO;

@Entity
@DiscriminatorValue( value="DH" )
public class DatosHermano extends DatosExtra {

	private String nombre;
	private String apellido;
	private String numeroDocumento;
	
	public DatosHermano() {
		
	}
	
//	public DatosHermano(DatosHermanoDTO dto) {
//		this.setId(dto.getId());
//		this.setColegio(new Colegio(dto.getColegio()));
//		this.nombre = dto.getNombre();
//		this.apellido = dto.getApellido();
//		this.numeroDocumento = dto.getNumeroDocumento();
//	}
//	
//	public DatosHermanoDTO toDTO() {
//		DatosHermanoDTO dto = new DatosHermanoDTO();
//		dto.setColegio(this.getColegio().toDTO());
//		dto.setId(this.getId());
//		dto.setNombre(this.nombre);
//		dto.setApellido(this.apellido);
//		dto.setNumeroDocumento(this.numeroDocumento);
//		return dto;
//	}
//
//	public String getNumeroDocumento() {
//		return numeroDocumento;
//	}
//
//	public void setNumeroDocumento(String numeroDocumento) {
//		this.numeroDocumento = numeroDocumento;
//	}
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public String getApellido() {
//		return apellido;
//	}
//
//	public void setApellido(String apellido) {
//		this.apellido = apellido;
//	}
}
