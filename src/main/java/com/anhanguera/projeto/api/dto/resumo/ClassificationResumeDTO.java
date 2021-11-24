package com.anhanguera.projeto.api.dto.resumo;

import java.util.ArrayList;
import java.util.List;

import com.anhanguera.projeto.domain.model.Classification;
import com.anhanguera.projeto.domain.model.User;

public class ClassificationResumeDTO {

	private Integer grade;
	private UserResumeDTO user;
	
	public ClassificationResumeDTO() {}
	
	public ClassificationResumeDTO(Integer grade, User user) {
		super();
		this.grade = grade;
		this.user = new UserResumeDTO().convertUserToResumeDTO(user);
	}
	
	public ClassificationResumeDTO convertClassificationToResumeDTO(Classification grade) {
		return new ClassificationResumeDTO(
					grade.getGrade(),
					grade.getUser()
				);
	}
	
	public List<ClassificationResumeDTO> convertListClassficationToResumeDTO(List<Classification> classfications){
		List<ClassificationResumeDTO> listDTO = new ArrayList<>();
		
		for(Classification classification: classfications) {
			ClassificationResumeDTO dto = new ClassificationResumeDTO(
						classification.getGrade(),
						classification.getUser()
					);
			listDTO.add(dto);
		}
		
		return listDTO;
	}
	

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public UserResumeDTO getUser() {
		return user;
	}
	public void setUser(UserResumeDTO user) {
		this.user = user;
	}
	
	
}
