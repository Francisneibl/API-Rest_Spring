package com.anhanguera.projeto.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anhanguera.projeto.domain.repository.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository genreRepository;
	
	public boolean existsById(Long id){
		return genreRepository.existsById(id);
	}
}
