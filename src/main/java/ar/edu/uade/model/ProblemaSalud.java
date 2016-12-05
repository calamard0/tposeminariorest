package ar.edu.uade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProblemaSalud {

	public static final String _alergia = "Alergia";
	public static final String _fisico = "Fisico";
	public static final String _sensorial = "Sensorial";
	public static final String _epileptico = "Epilepsia";
	
	private int id;
	private String descripcion;
	private Aspirante aspirante;
	
	public ProblemaSalud() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@ManyToOne
	public Aspirante getAspirante() {
		return aspirante;
	}
	public void setAspirante(Aspirante aspirante) {
		this.aspirante = aspirante;
	}
	
}
