package com.anhanguera.projeto.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anhanguera.projeto.domain.exception.BusinessException;
import com.anhanguera.projeto.domain.model.Classification;
import com.anhanguera.projeto.domain.repository.classification.ClassificationRepository;
import com.anhanguera.projeto.domain.repository.movie.MovieRepository;
import com.anhanguera.projeto.domain.repository.user.UserRepository;

@Service
public class ClassificationService {
	
	@Autowired
	private ClassificationRepository classificationRepository;
	@Autowired
	private MovieRepository movieRespository;
	@Autowired
	private UserRepository userRepository;
	
	public Classification save(Classification classification) {
		
		if(existsClassificationByUser(classification)) {
			throw new BusinessException("Este filme já foi classificado por este usuario");
		}
		
		if(!movieRespository.existsById(classification.getMovie().getId())) {
			throw new BusinessException("Filme não encotrado!");
		}
		
		if(!userRepository.existsById(classification.getUser().getId())) {
			throw new BusinessException("Usuario não encotrado!");
		}
		
		return classificationRepository.save(classification);
	}
	
	public List<Classification> findAll(){
		return classificationRepository.findAll();
	}
	
	public boolean existsClassificationByUser(Classification classification) {
		Long movieID = classification.getMovie().getId();
		Long userID = classification.getUser().getId();
		
		Optional<Classification> classificationFilter = classificationRepository.findByMovieAndUser(movieID, userID);
		if(classificationFilter.isPresent()) {
			return true;
		}
		return false;
	}
}
