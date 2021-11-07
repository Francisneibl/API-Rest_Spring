package com.anhanguera.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> list (){
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		return userRepository.findById(id)
				.map(user -> ResponseEntity.ok(user))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User add(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> update (@PathVariable Long id, @RequestBody User user){
		if(!userRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		user.setId(id);
		userRepository.save(user);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		if(!userRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		userRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
