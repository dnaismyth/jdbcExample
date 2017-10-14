package tutorial.springsetup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tutorial.springsetup.entity.Comment;
import tutorial.springsetup.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/api/games/{gameId}/comments", method = RequestMethod.GET)
	public List<Comment> findCommentsByGameId(@PathVariable("gameId") Long gameId) throws Exception{
		List<Comment> gameComments = commentService.findCommentsByGameId(gameId);
		return gameComments;
	}
	
	@RequestMapping(value = "/api/games/{gameId}/comments", method = RequestMethod.POST)
	public Comment createNewGameComment(@PathVariable("gameId") Long gameId, @RequestBody final Comment comment) throws Exception{
		Comment created = commentService.createGameComment(comment, gameId);
		return created;
	}
	
}
