package com.shunya.project2021.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shunya.project2021.Models.Anime;

@Repository

public interface AnimeRepository extends CrudRepository<Anime, Long> {
	List<Anime> findAll();
	List<Anime> findByDescriptionContaining(String search);
	//finds book with desc. containg the search
	Long countByTitleContaining(String search);
	//method counts how many titles contain a certain string
	Long deleteByTitleStartingWith(String search);
	//method deletes an anime that starts w/ a specific title.
	List<Anime> searchByTitle(String title);
}
