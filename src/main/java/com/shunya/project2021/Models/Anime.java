package com.shunya.project2021.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="animes")
public class Anime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 40)
	private String title;
	
	@NotBlank
	@Size(min = 5, max = 200)
	private String description;
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String genre;
	
	@NotNull
	@Min(100)
	private Integer releaseYear;
	
	@NotNull
	@Min(1) @Max(10)
	private Integer rating;
	
	 @Column(updatable=false)
	 
	 @ManyToMany(fetch=FetchType.LAZY)
	 @JoinTable(
			 name = "animeUser",
			 joinColumns = @JoinColumn(name="anime_id"),
			 inverseJoinColumns = @JoinColumn(name = "user_id")
			 )
	 private List<User> users;
	 
	 
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date createdAt;
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date updatedAt;
	public Anime() {
	}
	public Anime(String title, String desc, String genre, int year, int rating) {
		this.title = title;
		this.description = desc;
		this.genre = genre;
		this.releaseYear = year;
		this.rating = rating;
	}
	
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Integer getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	 
}
