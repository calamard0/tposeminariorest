package ar.edu.uade.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ar.edu.uade.dto.ResponsableEnColegioDTO;

@Entity
@DiscriminatorValue( value="DP" )
public class DatosPadre extends DatosExtra {

	private String fichaMunicipal;
	private String tipoResponsable;
	
	public DatosPadre() {
		
	}
	
	public DatosPadre(ResponsableEnColegioDTO dto) {
		this.setColegio(new Colegio(dto.getColegio()));
		this.fichaMunicipal = dto.getFicha();
		this.tipoResponsable = dto.getTipo();
	}
	
	public ResponsableEnColegioDTO toDTO() {
		ResponsableEnColegioDTO dto = new ResponsableEnColegioDTO();
		dto.setColegio(this.getColegio().toDTO());
		dto.setFicha(this.fichaMunicipal);
		dto.setTipo(this.tipoResponsable);
		return dto;
	}

	public String getTipoResponsable() {
		return tipoResponsable;
	}

	public void setTipoResponsable(String tipoResponsable) {
		this.tipoResponsable = tipoResponsable;
	}

	public String getFichaMunicipal() {
		return fichaMunicipal;
	}

	public void setFichaMunicipal(String fichaMunicipal) {
		this.fichaMunicipal = fichaMunicipal;
	}
}
