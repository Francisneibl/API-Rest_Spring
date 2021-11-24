package com.anhanguera.projeto.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anhanguera.projeto.domain.exception.BusinessException;
import com.anhanguera.projeto.domain.filters.MovieFilter;
import com.anhanguera.projeto.domain.model.Actor;
import com.anhanguera.projeto.domain.model.Movie;
import com.anhanguera.projeto.domain.repository.ActorRepository;
import com.anhanguera.projeto.domain.repository.DirectorRepository;
import com.anhanguera.projeto.domain.repository.GenreRepository;
import com.anhanguera.projeto.domain.repository.movie.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private DirectorRepository directorRepository;
	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private ActorRepository actorRepository;
	
	public List<Movie> listAll(){
		return movieRepository.findAll();
	}
	
	public Optional<Movie> findById(Long id){
		return movieRepository.findById(id);
	}
	
	public List<Movie> listOrderByTitle(MovieFilter filter){
		return movieRepository.listOrderByNameAndClassification(filter);
	}
	
	public Movie save(Movie movie) {
		
		if(!directorRepository.existsById(movie.getDirector().getId())) {
			throw new BusinessException("Diretor não encotrado");
		}
		
		if(!genreRepository.existsById(movie.getGenre().getId())) {
			throw new BusinessException("Genero não encontrado");
		}
		
		Long idActorNotFound = validActors(movie.getActors());
		if(idActorNotFound != 0) {
			throw new BusinessException("Ator com ID = "+idActorNotFound+" não encotrado!");
		}
		
		return movieRepository.save(movie);
	}
	
	public Long validActors(List<Actor> actors) {
		for(Actor actor: actors) {
			if(!actorRepository.existsById(actor.getId())) {
				return actor.getId();
			}
		}
		return (long) 0;
	}
	
	public boolean existsById(Long id) {
		return movieRepository.existsById(id);
	}
	
	public void deleteById(Long id) {
		if(!existsById(id)) {
			throw new BusinessException("Filme não encontrado");
		}
		movieRepository.deleteById(id);
	}
	
}
