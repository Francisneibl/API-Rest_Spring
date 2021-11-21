package com.anhanguera.projeto.api.dto.output;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.anhanguera.projeto.domain.model.User;

public class UserOutputDTO {

	private Long id;
	private String name;
	private String userName;
	private String email;
	private OffsetDateTime dateCreate;
	
	public UserOutputDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserOutputDTO(Long id,String name, String userName, String email, OffsetDateTime dateCreate) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.dateCreate= dateCreate;
	}
	
	public UserOutputDTO convetUserForDTO(User user) {
		return new UserOutputDTO(
				user.getId(),
				user.getName(),
				user.getUserName(),
				user.getEmail(),
				user.getDateCreate()
				);
		
	}
	
	public List<UserOutputDTO> convertUserListForDTO(List<User> listUser){
		List<UserOutputDTO> listDTO = new ArrayList<>();
		
		for(User user: listUser) {
			UserOutputDTO userDTO = new UserOutputDTO(
					user.getId(),
					user.getName(),
					user.getUserName(),
					user.getEmail(),
					user.getDateCreate()
			);
			listDTO.add(userDTO);
		}
		return listDTO;
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
	public OffsetDateTime getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(OffsetDateTime dataCreate) {
		this.dateCreate = dataCreate;
	}
	
	
	
}
