package com.anhanguera.projeto.api.dto.output;

import java.util.ArrayList;
import java.util.List;

import com.anhanguera.projeto.api.dto.resumo.ClassificationResumeDTO;
import com.anhanguera.projeto.domain.model.Actor;
import com.anhanguera.projeto.domain.model.Classification;
import com.anhanguera.projeto.domain.model.Director;
import com.anhanguera.projeto.domain.model.Genre;
import com.anhanguera.projeto.domain.model.Movie;

public class MovieOutputDTO {

	private String title;

	private String description;
	
	private Integer year;

	private Double mediaClassificacao;
	
	private Genre genre;

	private Director director;
	
	private List<Actor> actors;
	
	private List<ClassificationResumeDTO> classifications;
	
	public MovieOutputDTO() {}

	public MovieOutputDTO(String title, String description, Integer year, Genre genre, Director director,
			List<Actor> actors, List<Classification> classifications, Double mediaClassificacao) {
		super();
		this.title = title;
		this.description = description;
		this.year = year;
		this.genre = genre;
		this.director = director;
		this.actors = actors;
		this.classifications = new ClassificationResumeDTO().convertListClassficationToResumeDTO(classifications);
		this.mediaClassificacao = mediaClassificacao;
	}
	
	public MovieOutputDTO convertMovieForDTO(Movie movie) {
		return new MovieOutputDTO(
					movie.getTitle(),
					movie.getDescription(),
					movie.getYear(),
					movie.getGenre(),
					movie.getDirector(),
					movie.getActors(),
					movie.getClassifications(),
					movie.getMediaClassificacao()
				);
	}
	
	public List<MovieOutputDTO> convertListMovieForDTO(List<Movie> movies){
		List<MovieOutputDTO> listDTO = new ArrayList<>();
		
		for(Movie movie: movies) {
			MovieOutputDTO dto = new MovieOutputDTO(
						movie.getTitle(),
						movie.getDescription(),
						movie.getYear(),
						movie.getGenre(),
						movie.getDirector(),
						movie.getActors(),
						movie.getClassifications(),
						movie.getMediaClassificacao()
					);
			listDTO.add(dto);
		}
		
		return listDTO;
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
	
	public Double getMediaClassificacao() {
		return mediaClassificacao;
	}

	public void setMediaClassificacao(Double mediaClassificacao) {
		this.mediaClassificacao = mediaClassificacao;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<ClassificationResumeDTO> getClassifications() {
		return classifications;
	}

	public void setClassifications(List<ClassificationResumeDTO> classifications) {
		this.classifications = classifications;
	}
	
}
