package ar.edu.uade.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ar.edu.uade.dto.DatosLaboralesDTO;

@Entity
public class DatosLaborales {

	private int id;
	private String situacionLaboral;
	private String profesion;
	private boolean sostenFamiliar;
	private String telefono;
	private String datosReferencia;
	private Domicilio domicilio;
	
	public DatosLaborales() {
		
	}
	
	public DatosLaborales(DatosLaboralesDTO dto) {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSituacionLaboral() {
		return situacionLaboral;
	}

	public void setSituacionLaboral(String situacionLaboral) {
		this.situacionLaboral = situacionLaboral;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public boolean isSostenFamiliar() {
		return sostenFamiliar;
	}

	public void setSostenFamiliar(boolean sostenFamiliar) {
		this.sostenFamiliar = sostenFamiliar;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDatosReferencia() {
		return datosReferencia;
	}

	public void setDatosReferencia(String datosReferencia) {
		this.datosReferencia = datosReferencia;
	}

//	@ManyToOne
	@OneToOne(cascade=CascadeType.ALL)
	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
}
