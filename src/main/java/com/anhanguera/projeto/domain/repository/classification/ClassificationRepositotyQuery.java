package com.anhanguera.projeto.domain.repository.classification;

import java.util.List;

import com.anhanguera.projeto.domain.model.Movie;

public interface ClassificationRepositotyQuery {

	List<Movie> orderByTitleAndClassification();
}
