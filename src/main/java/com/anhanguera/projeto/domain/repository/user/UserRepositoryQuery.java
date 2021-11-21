package com.anhanguera.projeto.domain.repository.user;

import java.util.List;

import com.anhanguera.projeto.domain.model.User;

public interface UserRepositoryQuery {
	
	public List<User> orderByName();

}
