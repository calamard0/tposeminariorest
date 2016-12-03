package ar.edu.uade.dto;

public class HermanoEnColegioDTO {
	private String nombre;
	private String apellido;
	private String fechaNac;
	private String tipoDocumento;
	private String numeroDocumento;
	private String grado;
	private ColegioDTO colegio;

	public HermanoEnColegioDTO() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public ColegioDTO getColegio() {
		return colegio;
	}

	public void setColegio(ColegioDTO colegio) {
		this.colegio = colegio;
	}
}
