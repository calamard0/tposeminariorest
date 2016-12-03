package ar.edu.uade.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ar.edu.uade.dto.DatosPadreDTO;

@Entity
@DiscriminatorValue( value="DP" )
public class DatosPadre extends DatosExtra {

	private String fichaMunicipal;
	private String nombre;
	
	public DatosPadre() {
		
	}
	
	public DatosPadre(DatosPadreDTO dto) {
		this.setId(dto.getId());
		this.setColegio(new Colegio(dto.getColegio()));
		this.fichaMunicipal = dto.getFichaMunicipal();
		this.nombre = dto.getNombre();
	}
	
	public DatosPadreDTO toDTO() {
		DatosPadreDTO dto = new DatosPadreDTO();
		dto.setColegio(this.getColegio().toDTO());
		dto.setId(this.getId());
		dto.setNombre(this.nombre);
		dto.setFichaMunicipal(this.fichaMunicipal);
		return dto;
	}

	public String getFichaMunicipal() {
		return fichaMunicipal;
	}

	public void setFichaMunicipal(String fichaMunicipal) {
		this.fichaMunicipal = fichaMunicipal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
