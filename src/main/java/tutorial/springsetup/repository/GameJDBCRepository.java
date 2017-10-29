package tutorial.springsetup.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tutorial.springsetup.entity.Game;


@Repository
public class GameJDBCRepository extends BaseJDBCRepository {

	private final String SQL_SEARCH_BY_DESCRIPTION = "SELECT description, id, title FROM game g WHERE lower(g.description) LIKE lower(:desc);";

	public List<Game> searchForGamesByDescription(String searchTerm){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("desc", "%" + searchTerm + "%");	// wrap with "%" to find descriptions that include provided search term.
		return jdbcTemplate.query(SQL_SEARCH_BY_DESCRIPTION, params, new GameRowMapper());	// use jdbcTemplate extended from BaseJDBCRepository
	}
	
	private class GameRowMapper implements RowMapper<Game> {
		public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
			Game game = new Game();
			game.setDescription(rs.getString("description"));
			game.setId(rs.getLong("id"));
			game.setTitle(rs.getString("title"));
			return game;
		}	
	}
}
