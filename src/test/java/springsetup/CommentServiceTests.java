package springsetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tutorial.springsetup.App;
import tutorial.springsetup.entity.Comment;
import tutorial.springsetup.entity.Game;
import tutorial.springsetup.repository.CommentRepository;
import tutorial.springsetup.repository.GameRepository;
import tutorial.springsetup.service.CommentService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class CommentServiceTests {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private GameRepository gameRepo;
	
	@After
	public void tearDown(){
		commentRepo.deleteAll();
	}
	
	@Test
	public void testCreateAndFindComment() throws Exception{
		List<Game> results = gameRepo.findAll();
		List<Comment> gameComments = new ArrayList<Comment>();
		Comment newComment = new Comment();
		newComment.setAuthor("Dayna");
		newComment.setText("This is a cool game.");
		Comment created = null;
		if(results.size() > 0){
			created = commentService.createGameComment(newComment, results.get(0).getId());
			gameComments = commentService.findCommentsByGameId(results.get(0).getId());
		}
		Assert.assertNotNull(created);
		Assert.assertTrue(gameComments.size() > 0);
	}
	
	
	
	
}
