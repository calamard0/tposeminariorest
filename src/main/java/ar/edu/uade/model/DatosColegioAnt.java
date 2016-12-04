package ar.edu.uade.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ar.edu.uade.dto.JardinDTO;

@Entity
@DiscriminatorValue( value="CA" )
public class DatosColegioAnt extends DatosExtra {

	private String nombreJardin;
	private String direccionJardin;
	
	public DatosColegioAnt() {
		
	}
	
	public DatosColegioAnt(JardinDTO dto) {
		this.setNombreJardin(dto.getNombre());
		this.setDireccionJardin(dto.getDireccion());
	}
	
	public JardinDTO toDTO() {
		JardinDTO dto = new JardinDTO();
		dto.setDireccion(this.getDireccionJardin());
		dto.setNombre(this.getNombreJardin());
		return dto;
	}
	
	public String getNombreJardin() {
		return nombreJardin;
	}
	
	public void setNombreJardin(String nombreJardin) {
		this.nombreJardin = nombreJardin;
	}
	
	public String getDireccionJardin() {
		return direccionJardin;
	}
	
	public void setDireccionJardin(String direccionJardin) {
		this.direccionJardin = direccionJardin;
	}
}
