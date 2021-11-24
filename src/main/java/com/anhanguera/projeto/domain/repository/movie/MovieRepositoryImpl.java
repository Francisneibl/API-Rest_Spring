package com.anhanguera.projeto.domain.repository.movie;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import com.anhanguera.projeto.domain.filters.MovieFilter;
import com.anhanguera.projeto.domain.model.Actor;
import com.anhanguera.projeto.domain.model.Director;
import com.anhanguera.projeto.domain.model.Genre;
import com.anhanguera.projeto.domain.model.Movie;

public class MovieRepositoryImpl implements MovieRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Movie> listOrderByNameAndClassification(MovieFilter filter) {
		
		StringBuffer sql = new StringBuffer();
		
		System.out.println(filter.getTitle());
		sql.append("SELECT AVG(c.grade) as mediaVoto, m ");
		sql.append("FROM Movie m LEFT JOIN Classification c ");
		sql.append("ON c.movie = m.id ");

		if(StringUtils.isNotBlank(filter.getTitle())) {
			sql.append("WHERE m.title LIKE :title ");
		}
		
		if(filter.getGenreID()!= null) {
			sql.append("AND m.genre = :genre ");
		}
		
		if(filter.getDirectorID()!= null) {
			sql.append("AND m.director = :director ");
		}
		/*
		if(filter.getActorID()!= null) {
			sql.append("AND m.actors LIKE :actor ");
		}*/
		
		sql.append("GROUP BY m.id ");
		
		if(StringUtils.isNotBlank(filter.getOrderBy())) {
			sql.append("ORDER BY "+filter.getOrderBy());
			if(StringUtils.isNoneBlank(filter.getSortOrder())) {
				sql.append(" "+filter.getSortOrder());
			}
		}
		
		TypedQuery<Object[]> query = manager.createQuery(sql.toString(), Object[].class);
		
		if(StringUtils.isNotBlank(filter.getTitle())) {
			query.setParameter("title", "%"+filter.getTitle()+"%");
		}
		
		if(filter.getGenreID()!= null) {
			Genre genre = new Genre();
			genre.setId(filter.getGenreID());
			query.setParameter("genre", genre);
		}
		
		if(filter.getDirectorID() != null) {
			Director director = new Director();
			director.setId(filter.getDirectorID());
			query.setParameter("director", director);
		}
		
		if(filter.getActorID()!= null) {
			Actor actor = new Actor();
			actor.setId(filter.getActorID());
			query.setParameter("actor", actor);
		}
		
		List<Object[]> resultQuery = query.getResultList();
		
		List<Movie> listMovies = new ArrayList<>();
		
		for(Object[] row: resultQuery) {
			Movie movie = new Movie();
			movie = (Movie) row[1];
			if(row[0]!= null) {
				movie.setMediaClassificacao((Double)row[0]);
			}else {
				movie.setMediaClassificacao((double) 0);
			}
			
			listMovies.add(movie);
		}
		return listMovies;
		
	}

}
