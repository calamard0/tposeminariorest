package ar.edu.uade.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ar.edu.uade.dto.DatosColegioAntDTO;

@Entity
@DiscriminatorValue( value="CA" )
public class DatosColegioAnt extends DatosExtra {

	public DatosColegioAnt() {
		
	}
	
//	public DatosColegioAnt(DatosColegioAntDTO dto) {
//		this.setId(dto.getId());
//		this.setColegio(new Colegio(dto.getColegio()));
//	}
//	
//	public DatosColegioAntDTO toDTO() {
//		DatosColegioAntDTO dto = new DatosColegioAntDTO();
//		dto.setColegio(this.getColegio().toDTO());
//		dto.setId(this.getId());
//		return dto;
//	}
}
