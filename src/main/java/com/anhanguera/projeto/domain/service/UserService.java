package com.anhanguera.projeto.domain.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.anhanguera.projeto.domain.exception.BusinessException;
import com.anhanguera.projeto.domain.exception.EntidadeNotFoundException;
import com.anhanguera.projeto.domain.model.Authorities;
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
		return userRepository.findByIdActive(id);
	}
	
	public User save(User user) {
		
		Optional<User> userMail = userRepository.findByEmail(user.getEmail());
		if(userMail.isPresent()) {
			throw new BusinessException("Email já cadastrado");
		}
		
		Optional<User> userName = userRepository.findByUserName(user.getUserName());
		if(userName.isPresent()) {
			throw new BusinessException("UserName já utilizado");
		}
		
		user.setRole(Authorities.ROLE_USER);
		user.setEnabled(true);
		user.setDateCreate(OffsetDateTime.now());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		return userRepository.save(user);
		
	}
	
	public User update(Long id, User user) {
		
		Optional<User> userResult = findById(id);
		Optional<User> userMail = userRepository.findByEmail(user.getEmail());
		Optional<User> userName = userRepository.findByUserName(user.getUserName());
		
		if(!userResult.isPresent()) {
			throw new EntidadeNotFoundException("Usuario não encontrado!");
		}
		
		if(userMail.isPresent() && id != userMail.get().getId()) {
			throw new BusinessException("Email já cadastrado");
		}
		
		if(userName.isPresent() && id != userName.get().getId()) {
			throw new BusinessException("UserName já utilizado");
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
		
		String logedUser = SecurityContextHolder.getContext().getAuthentication().getName();
		Object credencial = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

		Optional<User> userResult = findById(id);
		if(!userResult.isPresent()) {
			throw new EntidadeNotFoundException("Usuario não encontrado!");
		}

		User user = userResult.get();
		
		if(!user.getUserName().equals(logedUser) && !credencial.toString().equals("[ROLE_ADMIN]")) {
			throw new EntidadeNotFoundException("Permissão negada! Somente admistradores podem excluir usuarios além deles mesmos!");
		}
		
		user.setEnabled(false);
		userRepository.save(user);
	}
	
	public void grandAdminRole(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new EntidadeNotFoundException("Usuario não encontrado!");
		}
		
		User user = userOptional.get();
		
		user.setRole(Authorities.ROLE_ADMIN);
		
		userRepository.save(user);
	}
	
	public boolean existsById(Long id) {
		return userRepository.existsById(id);
	}
	
}
