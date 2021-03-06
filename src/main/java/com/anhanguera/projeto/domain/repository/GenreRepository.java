package com.anhanguera.projeto.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anhanguera.projeto.domain.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
