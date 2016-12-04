package ar.edu.uade.dto;

public class ResponsableEnColegioDTO {
	
	private String ficha;
	private ColegioDTO colegio;
	private String tipo;

	public ResponsableEnColegioDTO() {
	}

	public String getFicha() {
		return ficha;
	}

	public void setFicha(String ficha) {
		this.ficha = ficha;
	}

	public ColegioDTO getColegio() {
		return colegio;
	}

	public void setColegio(ColegioDTO colegio) {
		this.colegio = colegio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
