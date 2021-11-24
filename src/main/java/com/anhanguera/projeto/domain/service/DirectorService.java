package com.anhanguera.projeto.domain.service;

import com.anhanguera.projeto.domain.repository.DirectorRepository;

public class DirectorService {
	private DirectorRepository repository;
	
	public boolean existsById(Long id) {
		return repository.existsById(id);
	}
}
