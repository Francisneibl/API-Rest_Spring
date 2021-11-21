package com.anhanguera.projeto.domain.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anhanguera.projeto.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryQuery{
	
	 Optional<User> findByUserName(String userName);

}
