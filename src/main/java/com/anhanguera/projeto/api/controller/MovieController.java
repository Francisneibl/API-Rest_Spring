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

import com.anhanguera.projeto.domain.filters.MovieFilter;
import com.anhanguera.projeto.domain.model.Movie;
import com.anhanguera.projeto.domain.repository.movie.MovieRepository;
import com.anhanguera.projeto.domain.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired MovieService movieService;
	
	@GetMapping
	public List<Movie> findAll(MovieFilter filter){
		return movieService.listOrderByTitle(filter);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> findById(@PathVariable Long id){
		return movieRepository.findById(id)
				.map(movie -> ResponseEntity.ok(movie))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Movie add(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Movie> update(@PathVariable Long id, @RequestBody Movie movie){
		if(!movieRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		movie.setId(id);
		movieRepository.save(movie);
		return ResponseEntity.ok(movie);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		if(!movieRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		movieRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
