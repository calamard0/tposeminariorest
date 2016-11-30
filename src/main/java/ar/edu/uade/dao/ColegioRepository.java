package ar.edu.uade.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uade.model.Colegio;


public interface ColegioRepository extends CrudRepository<Colegio, Integer> {

	public List<Colegio> findByNombre(String nombre);
	
}
