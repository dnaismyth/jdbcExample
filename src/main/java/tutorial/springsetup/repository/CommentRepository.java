package tutorial.springsetup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tutorial.springsetup.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	@Query("SELECT c FROM Comment c WHERE c.game.id = ?1")
	public List<Comment> findCommentsByGameId(Long gameId);
}
