package ar.edu.uade.dao;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uade.model.Aspirante;
import ar.edu.uade.model.PreInscripcion;

public interface PreInscripcionRepository  extends CrudRepository<PreInscripcion, Integer>{

}
