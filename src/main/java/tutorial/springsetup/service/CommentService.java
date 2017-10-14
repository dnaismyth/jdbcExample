package tutorial.springsetup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tutorial.springsetup.entity.Comment;
import tutorial.springsetup.entity.Game;
import tutorial.springsetup.repository.CommentRepository;
import tutorial.springsetup.repository.GameRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired 
	private GameRepository gameRepo;
	
	public List<Comment> findCommentsByGameId(Long gameId) throws Exception{
		if(gameId == null){
			throw new Exception("Invalid game id.");
		}
		
		List<Comment> results = commentRepo.findCommentsByGameId(gameId);
		return results;
	}
	
	public Comment createGameComment(Comment comment, Long gameId) throws Exception{
		if(comment == null || gameId == null){
			throw new Exception("Invalid parameters.");
		}
		
		Game game = gameRepo.findOne(gameId);
		if(game == null){
			throw new Exception("Cannot find game with id=" + gameId);
		}
		
		comment.setGame(game);	// Find the game by the provided gameId and set it
		
		Comment created = commentRepo.save(comment);	// "save" is provided by the extended JpaRepository interface
		return created;
	}
}
