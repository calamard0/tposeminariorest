package ar.edu.uade.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uade.model.Vacante;

public interface VacanteRepository extends CrudRepository<Vacante, Integer> {
	
}
