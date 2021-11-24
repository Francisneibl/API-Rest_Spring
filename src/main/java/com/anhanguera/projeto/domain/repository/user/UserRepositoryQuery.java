package com.anhanguera.projeto.domain.repository.user;

import java.util.List;
import java.util.Optional;

import com.anhanguera.projeto.domain.model.User;

public interface UserRepositoryQuery {
	
	public List<User> orderByName();
	public Optional<User> findByIdActive(Long id);
	public Optional<User> findByUserName(String userName);

}
