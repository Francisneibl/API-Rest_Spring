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

import com.anhanguera.projeto.domain.model.Director;
import com.anhanguera.projeto.domain.repository.DirectorRepository;

@RestController
@RequestMapping("/director")
public class DirectorController {

	@Autowired
	private DirectorRepository directorRepository;
	
	@GetMapping
	public List<Director> listAll(){
		return directorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Director> listById(@PathVariable Long id) {
		return directorRepository.findById(id)
				.map(director -> ResponseEntity.ok(director))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Director add(@RequestBody Director director) {
		return directorRepository.save(director);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Director> update(@PathVariable Long id, @RequestBody Director director){
		if(!directorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		director.setId(id);
		directorRepository.save(director);
		return ResponseEntity.ok(director);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		if(!directorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		directorRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
