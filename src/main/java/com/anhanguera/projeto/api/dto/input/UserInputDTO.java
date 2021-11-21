package com.anhanguera.projeto.api.dto.input;

import com.anhanguera.projeto.domain.model.User;

public class UserInputDTO {

	private Long id;
	private String name;
	private String userName;
	private String email;
	private String password;
	
	
	public User convertDtoForUser(UserInputDTO dto) {
		User user = new User();
		user.setName(dto.name);
		user.setUserName(dto.userName);
		user.setEmail(dto.email);
		user.setPassword(dto.password);
		
		return user;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
