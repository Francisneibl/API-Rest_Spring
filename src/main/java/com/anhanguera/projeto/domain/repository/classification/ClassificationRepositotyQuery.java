package com.anhanguera.projeto.domain.repository.classification;

import java.util.Optional;

import com.anhanguera.projeto.domain.model.Classification;

public interface ClassificationRepositotyQuery {

	Optional<Classification> findByMovieAndUser(Long MovieID, Long UserID);
}
