package com.anhanguera.projeto.domain.repository.classification;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.anhanguera.projeto.domain.model.Movie;

public class ClassificationRepositoryImpl implements ClassificationRepositotyQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Movie> orderByTitleAndClassification() {
		
		
		
		return null;
	}

}
