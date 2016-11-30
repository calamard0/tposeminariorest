package ar.edu.uade.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ar.edu.uade.dto.DatosColegioAntDTO;

@Entity
@DiscriminatorValue( value="CA" )
public class DatosColegioAnt extends DatosExtra {

	public DatosColegioAnt() {
		
	}
	
	public DatosColegioAnt(DatosColegioAntDTO dto) {
		
	}
}
