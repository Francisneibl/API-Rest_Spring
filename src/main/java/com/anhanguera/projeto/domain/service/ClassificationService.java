package com.anhanguera.projeto.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anhanguera.projeto.domain.model.Classification;
import com.anhanguera.projeto.domain.repository.ClassificationRepository;

@Service
public class ClassificationService {
	
	@Autowired
	private ClassificationRepository classificationRepository;
	
	public Classification save(Classification classification) {
		return classificationRepository.save(classification);
	}
	
	public List<Classification> findAll(){
		return classificationRepository.findAll();
	}
}
