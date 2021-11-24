package com.anhanguera.projeto.api.dto.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.anhanguera.projeto.domain.model.User;

public class UserInputDTO {

	@NotBlank
	private String name;
	
	@NotBlank
	private String userName;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	
	public User convertDtoForUser(UserInputDTO dto) {
		User user = new User();
		user.setName(dto.name);
		user.setUserName(dto.userName);
		user.setEmail(dto.email);
		user.setPassword(dto.password);
		
		return user;
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
