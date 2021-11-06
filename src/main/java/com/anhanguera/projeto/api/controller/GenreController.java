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

import com.anhanguera.projeto.domain.model.Genre;
import com.anhanguera.projeto.domain.repository.GenreRepository;

@RestController
@RequestMapping("/genre")
public class GenreController {

	@Autowired
	private GenreRepository genreRepository;
	
	@GetMapping
	public List<Genre> listar(){
		return genreRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Genre adicionar(@RequestBody Genre genre) {
		return genreRepository.save(genre);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Genre> update(@PathVariable Long id ,@RequestBody Genre genre){
		
		if(!genreRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		genre.setId(id);
		genreRepository.save(genre);
		return ResponseEntity.ok(genre);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Genre> findById(@PathVariable Long id){
		return genreRepository.findById(id)
				.map(genre -> ResponseEntity.ok(genre))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		if(!genreRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		genreRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
