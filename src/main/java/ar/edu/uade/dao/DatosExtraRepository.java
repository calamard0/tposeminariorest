package ar.edu.uade.dao;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uade.model.Aspirante;
import ar.edu.uade.model.DatosExtra;

public interface DatosExtraRepository extends CrudRepository<DatosExtra, Integer> {

}
