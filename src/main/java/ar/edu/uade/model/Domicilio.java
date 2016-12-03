package ar.edu.uade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.uade.dto.DomicilioDTO;

@Entity
public class Domicilio {

	private int id;
	private String provincia;
	private String calle;
	private int numero;
	private String villa;
	private int piso;
	private String departamento;
	private String codigoPostal;
	private String tipo;
	
	public Domicilio() {
	}

	public Domicilio(DomicilioDTO dto) {
		this.id = dto.getId();
		this.provincia = dto.getProvincia();
		this.calle = dto.getCalle();
		this.numero = dto.getNumero();
		this.villa = dto.getVilla();
		this.piso = dto.getPiso();
		this.departamento = dto.getDepartamento();
		this.codigoPostal = dto.getCodigoPostal();
		this.tipo = dto.getTipo();
	}
	
	public DomicilioDTO toDTO() {
		DomicilioDTO dto = new DomicilioDTO();
		dto.setCalle(this.calle);
		dto.setId(this.id);
		dto.setCodigoPostal(this.codigoPostal);
		dto.setDepartamento(this.departamento);
		dto.setNumero(this.numero);
		dto.setPiso(this.piso);
		dto.setProvincia(this.provincia);
		dto.setTipo(this.tipo);
		dto.setVilla(this.villa);
		return dto;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getVilla() {
		return villa;
	}

	public void setVilla(String villa) {
		this.villa = villa;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
