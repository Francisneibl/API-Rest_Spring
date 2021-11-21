package com.anhanguera.projeto.domain.repository.movie;

import java.util.List;

import com.anhanguera.projeto.domain.filters.MovieFilter;
import com.anhanguera.projeto.domain.model.Movie;

public interface MovieRepositoryQuery {
	List<Movie> listOrderByNameAndClassification(MovieFilter filter);
}
