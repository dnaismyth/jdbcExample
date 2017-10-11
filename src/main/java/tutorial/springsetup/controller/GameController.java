package tutorial.springsetup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tutorial.springsetup.entity.Game;
import tutorial.springsetup.service.GameService;

@RestController
public class GameController {

	@Autowired
	private GameService gameService;
	
	// An example of how this API would be called in browser might be something like: localhost:8080/api/games?title=mario
	@RequestMapping(value = "/api/games", method = RequestMethod.GET) 
	public List<Game> searchGamesByTitle(@RequestParam(value = "title", required = true) String title){
		List<Game> results = gameService.searchGamesByTitle(title);
		return results;
	}
	
	@RequestMapping(value = "/api/games", method = RequestMethod.POST)
	public Game createGame(@RequestBody final Game game) throws Exception{
		Game created = gameService.insertGame(game);
		return created;
	}
	
}
