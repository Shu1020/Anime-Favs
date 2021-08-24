package com.shunya.project2021.Services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.shunya.project2021.Models.Anime;
import com.shunya.project2021.Repositories.AnimeRepository;

@Service
public class AnimeService {
	private final AnimeRepository animeRepo;
	
	public AnimeService(AnimeRepository animeRepo) {
		this.animeRepo = animeRepo;
	}
	// find all the animes
	public List<Anime> allAnimes() {
		return animeRepo.findAll();
	}
	//creat anime
	public Anime createAnime(Anime a) {
		return animeRepo.save(a);
	}
	//retrives a anime
//	public Anime findAnime(Long id) {
//		Optional<Anime> optionalAnime = animeRepo.findById(id);
//		if(optionalAnime.isPresent()) {
//			return optionalAnime.get();
//		} else {
//			return null;
//		}
//	}
	
	public Anime findAnime(Long id) {
		return this.animeRepo.findById(id).orElse(null);
	}
	
	public List<Anime> searchAnime(String title){
		return animeRepo.searchByTitle(title);
	}
	public Anime updateAnime(@Valid Anime anime) {
		return this.animeRepo.save(anime);
		
	}
	public String deleteAnime(Long id) {
		this.animeRepo.deleteById(id);
		return "Anime" + id + "has been deleted.";
		
	}
}
