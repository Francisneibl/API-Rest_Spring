package com.anhanguera.projeto.domain.repository.classification;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.anhanguera.projeto.domain.model.Classification;


public class ClassificationRepositoryImpl implements ClassificationRepositotyQuery{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Optional<Classification> findByMovieAndUser(Long movieID, Long userID) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c FROM Classification c ");
		sql.append("WHERE c.movie.id = :movieID ");
		sql.append("AND c.user.id = :userID");
		
		TypedQuery<Classification> query = manager.createQuery(sql.toString(), Classification.class);
		query.setParameter("movieID", movieID);
		query.setParameter("userID", userID);
		
		try {
			Classification result = query.getSingleResult();
			return Optional.of(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return Optional.empty();
	}
	


}
