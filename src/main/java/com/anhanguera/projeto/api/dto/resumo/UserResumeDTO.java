package com.anhanguera.projeto.api.dto.resumo;

import com.anhanguera.projeto.domain.model.User;

public class UserResumeDTO {
	
	private Long id;
	private String name;
	private String userName;
	
	public UserResumeDTO() {}
	
	public UserResumeDTO(Long id, String name, String userName) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
	}
	
	public UserResumeDTO convertUserToResumeDTO(User user) {
		return new UserResumeDTO(
					user.getId(),
					user.getName(),
					user.getUserName()
				);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
