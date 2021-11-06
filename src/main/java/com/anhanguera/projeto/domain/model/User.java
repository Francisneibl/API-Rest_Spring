package com.anhanguera.projeto.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@NotBlank
	@Column(name="name")
	@Size(max=255)
	private String name;
	
	@NotBlank
	@Column(name="email")
	@Size(max=255)
	private String email;
	
	@NotBlank
	@Column(name="date_create")
	private String date_create;
	
	
	@Column(name="administrador")
	private Boolean administradoristrador;
	
	
	@Column(name="is_active")
	private Boolean active;

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate_create() {
		return date_create;
	}

	public void setDate_create(String date_create) {
		this.date_create = date_create;
	}

	public Boolean getAdministradoristrador() {
		return administradoristrador;
	}

	public void setAdministradoristrador(Boolean administradoristrador) {
		this.administradoristrador = administradoristrador;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}


	
	
	
}
