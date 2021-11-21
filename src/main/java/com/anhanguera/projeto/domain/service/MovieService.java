package com.anhanguera.projeto.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anhanguera.projeto.domain.filters.MovieFilter;
import com.anhanguera.projeto.domain.model.Movie;
import com.anhanguera.projeto.domain.repository.movie.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> listAll(){
		return movieRepository.findAll();
	}
	
	public List<Movie> listOrderByTitle(MovieFilter filter){
		return movieRepository.listOrderByNameAndClassification(filter);
	}
	
}
