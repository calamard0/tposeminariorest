package ar.edu.uade.dao;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uade.model.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {

	
	
}
