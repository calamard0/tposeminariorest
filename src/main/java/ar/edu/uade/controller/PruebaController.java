package ar.edu.uade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uade.dao.GameRepository;
import ar.edu.uade.model.Game;

@RestController
public class PruebaController {

	@Autowired
	 GameRepository gameRepository;
	
	@RequestMapping(value = "/insertGame/{nameGame}/{descriptionGame}")
	public void setGame(@PathVariable final String nameGame,@PathVariable final String descriptionGame) {
		
//		gameRepository.deleteAll();
		
		Game pandemic = new Game(nameGame, descriptionGame);
		gameRepository.save(pandemic);
	}
	
	@RequestMapping(value = "/games/{gameNumber}")
	public Game getGame(@PathVariable final int gameNumber) {
		return gameRepository.findOne(gameNumber);
	}
	
}
