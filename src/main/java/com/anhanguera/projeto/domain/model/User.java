package com.anhanguera.projeto.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name="user")
public class User {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
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
	@Temporal(TemporalType.TIMESTAMP)
	private String date_create;
	
	@NotBlank
	@Column(name="is_admin")
	private Boolean IsAdmi;
	
	@NotBlank
	@Column(name="is_active")
	private Boolean IsActive;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
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

	public Boolean getIsAdmi() {
		return IsAdmi;
	}

	public void setIsAdmi(Boolean isAdmi) {
		IsAdmi = isAdmi;
	}

	public Boolean getIsActive() {
		return IsActive;
	}

	public void setIsActive(Boolean isActive) {
		IsActive = isActive;
	}
	
	
	
}
