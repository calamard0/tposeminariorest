package ar.edu.uade.dto;

public class ResponsableEnColegioDTO {
	
	private String ficha;
	private ColegioDTO colegio;

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

}
