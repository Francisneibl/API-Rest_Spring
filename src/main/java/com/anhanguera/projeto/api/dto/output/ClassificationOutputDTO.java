package com.anhanguera.projeto.api.dto.output;


import java.util.ArrayList;
import java.util.List;

import com.anhanguera.projeto.api.dto.resumo.MovieResumoDTO;
import com.anhanguera.projeto.api.dto.resumo.UserResumeDTO;
import com.anhanguera.projeto.domain.model.Classification;
import com.anhanguera.projeto.domain.model.Movie;
import com.anhanguera.projeto.domain.model.User;

public class ClassificationOutputDTO {

	private Long id;
	private Integer grade;
	private MovieResumoDTO movie;
	private UserResumeDTO user;
	
	public ClassificationOutputDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ClassificationOutputDTO(Long id, Integer grade, Movie movie, User user) {
		this.id = id;
		this.grade = grade;
		this.movie = new MovieResumoDTO().convertMovieToResumoDTO(movie);
		this.user = new UserResumeDTO().convertUserToResumeDTO(user);
		
	}
	
	public ClassificationOutputDTO convertClassificationForDTO(Classification classification) {
		return new ClassificationOutputDTO(
					classification.getId(),
					classification.getGrade(),
					classification.getMovie(),
					classification.getUser()
				);
	}
	
	public List<ClassificationOutputDTO> convertClassificationListToDTO(List<Classification> classifications){
		List<ClassificationOutputDTO> listDTO = new ArrayList<>();
		
		for(Classification classification: classifications) {
			ClassificationOutputDTO classDTO = new ClassificationOutputDTO
					(
					classification.getId(),
					classification.getGrade(),
					classification.getMovie(),
					classification.getUser()
					);
			listDTO.add(classDTO);
		}
		
		return listDTO;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer classification) {
		this.grade = classification;
	}
	public MovieResumoDTO getMovie() {
		return movie;
	}
	public void setMovie(MovieResumoDTO movie) {
		this.movie = movie;
	}
	public UserResumeDTO getUser() {
		return user;
	}
	public void setUser(UserResumeDTO user) {
		this.user = user;
	}
}
