package com.anhanguera.projeto.api.dto.input;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import com.anhanguera.projeto.domain.model.Classification;
import com.anhanguera.projeto.domain.model.Movie;
import com.anhanguera.projeto.domain.model.User;

public class ClassificationInputDTO {

	@NotNull
	@Max(value = 4,message = "O valor maximo é 4")
	private Integer grade;
	@NotNull
	private Long movieID;
	@NotNull
	private Long userID;
	
	public ClassificationInputDTO() {}

	public ClassificationInputDTO(@NotNull Integer grade, @NotNull Long movieID, @NotNull Long userID) {
		super();
		this.grade = grade;
		this.movieID = movieID;
		this.userID = userID;
	}
	
	public Classification convertDTOForClassification(ClassificationInputDTO dto) {
		Classification classification = new Classification();
		
		classification.setGrade(dto.getGrade());
		
		classification.setMovie(new Movie(dto.getMovieID()));
		classification.setUser(new User(dto.getUserID()));
		
		return classification;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Long getMovieID() {
		return movieID;
	}

	public void setMovieID(Long movieID) {
		this.movieID = movieID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}
	
	
}
