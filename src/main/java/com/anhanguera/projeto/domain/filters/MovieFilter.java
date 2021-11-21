package com.anhanguera.projeto.domain.filters;

public class MovieFilter {

	private String title;
	private Long genreID;
	private Long directorID;
	private Long actorID;
	private String orderBy;
	private String sortOrder;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getGenreID() {
		return genreID;
	}
	public void setGenreID(Long genreID) {
		this.genreID = genreID;
	}
	public Long getDirectorID() {
		return directorID;
	}
	public void setDirectorID(Long directorID) {
		this.directorID = directorID;
	}
	public Long getActorID() {
		return actorID;
	}
	public void setActorID(Long actorID) {
		this.actorID = actorID;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
}
