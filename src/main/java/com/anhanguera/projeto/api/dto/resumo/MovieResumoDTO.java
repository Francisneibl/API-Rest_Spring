package com.anhanguera.projeto.api.dto.resumo;

import com.anhanguera.projeto.domain.model.Movie;

public class MovieResumoDTO {

	private Long id;
	private String title;
	private String description;
	
	public MovieResumoDTO convertMovieToResumoDTO(Movie movie) {
		
		MovieResumoDTO movieDTO = new MovieResumoDTO();
		movieDTO.setId(movie.getId());
		movieDTO.setTitle(movie.getTitle());
		movieDTO.setDescription(movie.getDescription());
		
		return movieDTO;
	}
	
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
	
}
