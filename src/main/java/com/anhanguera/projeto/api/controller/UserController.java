package com.anhanguera.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User adicionar(@RequestBody User user) {
		System.out.println(user.getEmail());
		return userRepository.save(user);
	}
}
