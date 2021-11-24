package com.anhanguera.projeto.api.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.anhanguera.projeto.api.dto.input.MovieInputDTO;
import com.anhanguera.projeto.api.dto.output.MovieOutputDTO;
import com.anhanguera.projeto.domain.filters.MovieFilter;
import com.anhanguera.projeto.domain.model.Movie;
import com.anhanguera.projeto.domain.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping
	public List<MovieOutputDTO> findAll(MovieFilter filter){
		List<Movie> movieResult = movieService.listOrderByTitle(filter);
		
		return new MovieOutputDTO().convertListMovieForDTO(movieResult);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieOutputDTO> findById(@PathVariable Long id){
		return movieService.findById(id)
				.map(movie -> ResponseEntity.ok(new MovieOutputDTO().convertMovieForDTO(movie)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Movie add(@Valid @RequestBody MovieInputDTO movieInput) {
		Movie movie = new MovieInputDTO().convetInputDTOForMovie(movieInput);
		return movieService.save(movie);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Movie> update(@PathVariable Long id, @RequestBody Movie movie){
		if(!movieService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		movie.setId(id);
		movieService.save(movie);
		return ResponseEntity.ok(movie);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		if(!movieService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		movieService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
