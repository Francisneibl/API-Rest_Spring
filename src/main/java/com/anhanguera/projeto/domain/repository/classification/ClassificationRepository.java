package com.anhanguera.projeto.domain.repository.classification;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anhanguera.projeto.domain.model.Classification;

public interface ClassificationRepository extends JpaRepository<Classification, Long>, ClassificationRepositotyQuery{

}
