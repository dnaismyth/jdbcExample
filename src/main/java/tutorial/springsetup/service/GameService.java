package tutorial.springsetup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tutorial.springsetup.entity.Game;
import tutorial.springsetup.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepo;	// Autowire in our GameRepository to allow access to all public methods
	
	public List<Game> searchGamesByTitle(String title){
		String formattedTitle = "%" + title + "%";	// wrap '%' around the input title parameter so that we can find values with value of title in any position
		List<Game> results = gameRepo.findGamesByTitle(formattedTitle); // now perform our repository query
		return results;	// return results
	}
	
	public Game insertGame(Game game) throws Exception {
		if(game == null){
			throw new Exception("Invalid input!");
		}
		
		Game insertedGame = gameRepo.save(game);	// Save the game into the database and store the returned value
		return insertedGame;	// return the inserted game
	}
	
}
