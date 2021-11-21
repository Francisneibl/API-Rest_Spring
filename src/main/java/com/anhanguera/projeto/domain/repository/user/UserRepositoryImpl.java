package com.anhanguera.projeto.domain.repository.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.anhanguera.projeto.domain.model.User;

public class UserRepositoryImpl implements UserRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<User> orderByName() {
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT u FROM User u ");
		sql.append("WHERE u.enabled=true ");
		sql.append("AND u.role='ROLE_USER' ");
		sql.append("ORDER BY u.userName");
		
		
		TypedQuery<User> query = manager.createQuery(sql.toString(), User.class);
	
		
		return query.getResultList();
	}

}
