package com.anhanguera.projeto.api.dto.input;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.anhanguera.projeto.domain.model.Actor;
import com.anhanguera.projeto.domain.model.Director;
import com.anhanguera.projeto.domain.model.Genre;
import com.anhanguera.projeto.domain.model.Movie;


public class MovieInputDTO {
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String description;
	
	@NotNull
	private Integer year;
	
	@NotNull
	private Long genreID;
	
	@NotNull
	private Long directorID;
	
	private List<Long> actorsID;
	
	
	public MovieInputDTO() {
	}
	
	public MovieInputDTO(@NotBlank String title, @NotBlank String description, @NotEmpty Integer year,
			@NotEmpty Long genreID, @NotEmpty Long directorID, @NotEmpty List<Long> actorsID) {
		super();
		this.title = title;
		this.description = description;
		this.year = year;
		this.genreID = genreID;
		this.directorID = directorID;
		this.actorsID = actorsID;
	}

	public Movie convetInputDTOForMovie(MovieInputDTO dto) {
		Movie movie = new Movie();
		movie.setTitle(dto.getTitle());
		movie.setDescription(dto.getDescription());
		movie.setYear(dto.getYear());
		
		movie.setGenre(new Genre(dto.getGenreID()));
		movie.setDirector(new Director(dto.directorID));
		
		List<Actor> listActors = new ArrayList<>();
		for(Long id: dto.getActorsID()) {
			listActors.add(new Actor(id));
		}
		movie.setActors(listActors);
		return movie;
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
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}

	public Long getGenreID() {
		return genreID;
	}

	public void setGenreID(Long genreID) {
		this.genreID = genreID;
	}

	public Long getDirectorID() {
		return directorID;
	}

	public void setDirectorID(Long directorID) {
		this.directorID = directorID;
	}

	public List<Long> getActorsID() {
		return actorsID;
	}

	public void setActorsID(List<Long> actorsID) {
		this.actorsID = actorsID;
	}

}