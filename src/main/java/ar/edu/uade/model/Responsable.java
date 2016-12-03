package ar.edu.uade.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ar.edu.uade.dto.ResponsableDTO;

@Entity
public class Responsable {

	private int id;
	private String nombre;
	private String apellido;
	private String tipoDocumento;
	private String numeroDocumento;
	private String vinculoAspirante;
	private String paisNacimiento;
	private String email;
	private String telefonoParticular;
	private String telefonoAlternativo;
	private DatosLaborales datosLaborales;
	private Domicilio domicilio;
	
	public Responsable() {
		
	}
	
	public Responsable(ResponsableDTO dto) {
		this.id = dto.getId();
		this.nombre = dto.getNombre();
		this.apellido = dto.getApellido();
		this.tipoDocumento = dto.getTipoDocumento();
		this.numeroDocumento = dto.getNumeroDocumento();
		this.vinculoAspirante = dto.getVinculoAspirante();
		this.paisNacimiento = dto.getPaisNacimiento();
		this.email = dto.getEmail();
		this.telefonoAlternativo = dto.getTelefonoAlternativo();
		this.telefonoParticular = dto.getTelefonoParticular();
		this.datosLaborales = new DatosLaborales(dto.getDatosLaborales());
		//this.domicilio = new Domicilio(dto.getDomic)
	}
	
	public ResponsableDTO toDTO() {
		ResponsableDTO dto = new ResponsableDTO();
		dto.setId(this.id);
		dto.setNombre(this.nombre);
		dto.setApellido(this.apellido);
		dto.setTipoDocumento(this.tipoDocumento);
		dto.setNumeroDocumento(this.numeroDocumento);
		dto.setVinculoAspirante(this.vinculoAspirante);
		dto.setPaisNacimiento(this.paisNacimiento);
		dto.setEmail(this.email);
		dto.setTelefonoAlternativo(this.telefonoAlternativo);
		dto.setTelefonoParticular(this.telefonoParticular);
		dto.setDatosLaborales(this.datosLaborales.toDTO());
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

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getVinculoAspirante() {
		return vinculoAspirante;
	}

	public void setVinculoAspirante(String vinculoAspirante) {
		this.vinculoAspirante = vinculoAspirante;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonoParticular() {
		return telefonoParticular;
	}

	public void setTelefonoParticular(String telefonoParticular) {
		this.telefonoParticular = telefonoParticular;
	}

	public String getTelefonoAlternativo() {
		return telefonoAlternativo;
	}

	public void setTelefonoAlternativo(String telefonoAlternativo) {
		this.telefonoAlternativo = telefonoAlternativo;
	}

	@OneToOne(cascade=CascadeType.ALL)
	public DatosLaborales getDatosLaborales() {
		return datosLaborales;
	}

	public void setDatosLaborales(DatosLaborales datosLaborales) {
		this.datosLaborales = datosLaborales;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getPaisNacimiento() {
		return paisNacimiento;
	}

	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}

	@OneToOne(cascade=CascadeType.ALL)
	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
}
