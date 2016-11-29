package ar.edu.uade.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//@Entity
public class DatosExtra {

	private int id;
	private Colegio colegio;
	private DatosHermano datosHermano;
	private DatosPadre datosPadre;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Colegio getColegio() {
		return colegio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	@OneToOne(cascade=CascadeType.ALL)
	public DatosHermano getDatosHermano() {
		return datosHermano;
	}

	public void setDatosHermano(DatosHermano datosHermano) {
		this.datosHermano = datosHermano;
	}

	@OneToOne(cascade=CascadeType.ALL)
	public DatosPadre getDatosPadre() {
		return datosPadre;
	}

	public void setDatosPadre(DatosPadre datosPadre) {
		this.datosPadre = datosPadre;
	}
}
