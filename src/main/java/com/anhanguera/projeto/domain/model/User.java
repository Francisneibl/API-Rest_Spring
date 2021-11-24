package com.anhanguera.projeto.domain.model;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="users")
public class User {
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(Long id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "name")
	private String name;
	
	@NotBlank
	@Column(name = "username")
	private String userName;
	
	@NotBlank
	@Email
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@Column(name = "password")
	private String password;
	
	@Column(name = "date_create")
	private OffsetDateTime dateCreate;
	
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Authorities role;
	
	@Column(name = "enabled")
	private Boolean enabled;
	
	@OneToMany(mappedBy = "grade")
	private List<Classification> classifications;

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

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public OffsetDateTime getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(OffsetDateTime dataCreate) {
		this.dateCreate = dataCreate;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public Authorities getRole() {
		return role;
	}

	public void setRole(Authorities role) {
		this.role = role;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Classification> getClassifications() {
		return classifications;
	}

	public void setClassifications(List<Classification> classifications) {
		this.classifications = classifications;
	}
	
	
}
