package com.anhanguera.projeto.domain.model;

import java.util.List;
	
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "movie")
public class Movie {
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(Long id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "title")
	private String title;
	
	@NotBlank
	@Column(name  = "description")
	private String description;
	
	@NotNull
	@Column(name  = "year")
	private Integer year;
	
	@ManyToOne
	@JoinColumn(name = "fk_genre")
	private Genre genre;
	
	@ManyToOne
	@JoinColumn(name = "fk_director")
	private Director director;
	
	@ManyToMany
	@JoinTable(
			name="movie_has_actor",
			joinColumns = @JoinColumn(name = "fk_movie"),
			inverseJoinColumns = @JoinColumn(name = "fk_actor"))
	private List<Actor> actors;
	
	@OneToMany(mappedBy = "movie")
	private List<Classification> classifications;
	
	@Transient
	private Double mediaClassificacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Classification> getClassifications() {
		return classifications;
	}

	public void setClassifications(List<Classification> classifications) {
		this.classifications = classifications;
	}

	public Double getMediaClassificacao() {
		return mediaClassificacao;
	}

	public void setMediaClassificacao(Double mediaClassificacao) {
		this.mediaClassificacao = mediaClassificacao;
	}


	
}
