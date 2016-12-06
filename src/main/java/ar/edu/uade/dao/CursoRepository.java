package ar.edu.uade.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uade.model.Curso;

public interface CursoRepository extends CrudRepository<Curso, Integer> {

	public List<Curso> findByGrado(int grado);
	
}
