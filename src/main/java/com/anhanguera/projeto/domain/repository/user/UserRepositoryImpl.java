package com.anhanguera.projeto.domain.repository.user;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.anhanguera.projeto.domain.exception.EntidadeNotFoundException;
import com.anhanguera.projeto.domain.model.User;

public class UserRepositoryImpl implements UserRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<User> orderByName() {
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT u FROM User u ");
		sql.append("WHERE u.enabled=true ");
		sql.append("ORDER BY u.userName");
		
		
		TypedQuery<User> query = manager.createQuery(sql.toString(), User.class);
	
		
		return query.getResultList();
	}

	@Override
	public Optional<User> findByIdActive(Long id) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT u FROM User u ");
		sql.append("WHERE u.id = :userId ");
		sql.append("AND u.enabled = true ");
		
		TypedQuery<User> query = manager.createQuery(sql.toString(), User.class);
		query.setParameter("userId", id);
		
		try {
			User userResult = query.getSingleResult();
			Optional<User> userOp = Optional.of(userResult);
			return userOp;
		} catch (Exception e) {
			throw new EntidadeNotFoundException("Usuario não encontrado !");
		}			
	
	}

	@Override
	public Optional<User> findByUserName(String userName) {
		System.out.println("entrou");
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT u FROM User u WHERE u.userName = :p");
		
		TypedQuery<User> query = manager.createQuery(sql.toString(), User.class);
		query.setParameter("p", userName);
		
		try {
			User userResult = query.getSingleResult();
			return Optional.of(userResult);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Optional.empty();
	}
	

}
