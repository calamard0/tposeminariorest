package ar.edu.uade.dto;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.edu.uade.model.PreInscripcion;

public class PreInscripcionDTO {
	
	private int id;
	private AspiranteDTO aspirante;
	private String estado;
	private ResponsableDTO responsable;
	private boolean validada;
	private DatosExtraDTO datosExtra;
	private List<CursoDTO> cursos;
	
	public PreInscripcionDTO() {
		
	}
	
	public PreInscripcionDTO(PreInscripcion pre) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.convertValue(pre, PreInscripcionDTO.class);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public AspiranteDTO getAspirante() {
		return aspirante;
	}
	public void setAspirante(AspiranteDTO aspirante) {
		this.aspirante = aspirante;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public ResponsableDTO getResponsable() {
		return responsable;
	}
	public void setResponsable(ResponsableDTO responsable) {
		this.responsable = responsable;
	}
	public boolean isValidada() {
		return validada;
	}
	public void setValidada(boolean validada) {
		this.validada = validada;
	}
	public DatosExtraDTO getDatosExtra() {
		return datosExtra;
	}
	public void setDatosExtra(DatosExtraDTO datosExtra) {
		this.datosExtra = datosExtra;
	}

	public List<CursoDTO> getCursos() {
		return cursos;
	}

	public void setCursos(List<CursoDTO> cursos) {
		this.cursos = cursos;
	}
	
}
