package com.anhanguera.projeto.domain.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.anhanguera.projeto.domain.exception.EntidadeNotFoundException;
import com.anhanguera.projeto.domain.model.User;
import com.anhanguera.projeto.domain.repository.user.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	public List<User> findAll(){
		return userRepository.orderByName();
	}
	
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
	
	public User save(User user) {
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		user.setDateCreate(OffsetDateTime.now());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		return userRepository.save(user);
		
	}
	
	public User update(Long id, User user) {
		
		Optional<User> userResult = findById(id);
		
		if(!userResult.isPresent()) {
			throw new EntidadeNotFoundException("Usuario não encontrado!");
		}
		User userOld = userResult.get();
		user.setId(id);
		user.setRole(userOld.getRole());
		user.setEnabled(userOld.getEnabled());
		user.setDateCreate(userOld.getDateCreate());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
		
	}
	
	public void deleteLogicalById(Long id) {
		
		Optional<User> userResult = findById(id);
		if(!userResult.isPresent()) {
			throw new EntidadeNotFoundException("Usuario não encontrado!");
		}
		User user = userResult.get();
		
		user.setEnabled(false);
		userRepository.save(user);
	}
	
	public boolean existsById(Long id) {
		return userRepository.existsById(id);
	}
	
}
