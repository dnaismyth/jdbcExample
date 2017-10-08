package tutorial.springsetup.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game") // The name of the table that will be mapped to our database
public class Game {

	@Id	// This will represent our primary key.
    @GeneratedValue(strategy = GenerationType.AUTO)	// Auto generate an id.
	private Long id;
	
	// The title of a game
	@Column(name = "title")
	private String title;
	
	// A description of the game
	@Column(name = "description")
	private String description;
	
	// Release date of the game
	@Column(name = "release_date")
	private Date releaseDate;
	
	public Game(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}	
}
