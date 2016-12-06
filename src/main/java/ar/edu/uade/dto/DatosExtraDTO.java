package ar.edu.uade.dto;

public class DatosExtraDTO {

	private int id;
	private JardinDTO jardinAnterior;
	private HermanoEnColegioDTO hermanoEnColegio;
	private ResponsableEnColegioDTO responsableEnColegio;

	public DatosExtraDTO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JardinDTO getJardinAnterior() {
		return jardinAnterior;
	}

	public void setJardinAnterior(JardinDTO jardinAnterior) {
		this.jardinAnterior = jardinAnterior;
	}

	public HermanoEnColegioDTO getHermanoEnColegio() {
		return hermanoEnColegio;
	}

	public void setHermanoEnColegio(HermanoEnColegioDTO hermanoEnColegio) {
		this.hermanoEnColegio = hermanoEnColegio;
	}

	public ResponsableEnColegioDTO getResponsableEnColegio() {
		return responsableEnColegio;
	}

	public void setResponsableEnColegio(ResponsableEnColegioDTO responsableEnColegio) {
		this.responsableEnColegio = responsableEnColegio;
	}

}