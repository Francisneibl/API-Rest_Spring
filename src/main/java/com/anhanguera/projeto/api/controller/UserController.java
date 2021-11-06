package com.anhanguera.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anhanguera.projeto.domain.model.User;
import com.anhanguera.projeto.domain.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserRepository userRepository;
	
	@GetMapping
	public List<User> listar(){
		return userRepository.findAll();
	}
}
