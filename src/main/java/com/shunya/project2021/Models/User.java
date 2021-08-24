package com.shunya.project2021.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	@Email
	@NotBlank
	private String email;
	private String password;
	@Transient
	private String passwordConf;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			 name = "animeUser",
			 joinColumns = @JoinColumn(name="user_id"),
			 inverseJoinColumns = @JoinColumn(name = "anime_id")
			 )
	private List<Anime> animes;
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCsonf() {
		return passwordConf;
	}

	public void setPasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
	}

	
	public List<Anime> getAnimes() {
		return animes;
	}

	public void setAnimes(List<Anime> animes) {
		this.animes = animes;
	}

	public Object getConfirmPassword() {
		return null;
	}
	
	
}