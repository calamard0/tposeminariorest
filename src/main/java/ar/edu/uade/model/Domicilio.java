package ar.edu.uade.model;

import ar.edu.uade.dto.DomicilioDTO;

public class Domicilio {

	private String provincia;
	private String calle;
	private int numero;
	private String villa;
	private int piso;
	private String depto;
	private String codigoPostal;
	private String tipo;
	
	public Domicilio(DomicilioDTO dto) {
		
	}
	
	public int grabar() {
		return 0;
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

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
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
