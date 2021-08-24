package com.shunya.project2021.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shunya.project2021.Models.Anime;
import com.shunya.project2021.Models.User;
import com.shunya.project2021.Services.AnimeService;
import com.shunya.project2021.Services.UserService;

@Controller
public class AnimeApi {
	private AnimeService animeService;
	private UserService uService;
	
	public AnimeApi(AnimeService animeService) {
		this.animeService = animeService;
	}
	@GetMapping("/login")
	public String homePage(@ModelAttribute("email") User user) {
		return "homepage.jsp";
	}
//	@PostMapping("/login")
//	//Reminder: RequestParam->used for jsp files later on.
//	public String login(@Valid @ModelAttribute("userToLogin") Long userId, HttpSession session, BindingResult result) {
//		if (result.hasErrors()) {
//			return "homepage.jsp";
//		}
//		session.setAttribute("userLogin", userId);
//		return "redirect:/login";
//	}
	
	@PostMapping("/login")
	public String login(@RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAttr, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttr.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/login";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/animes";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	@GetMapping("/animes")
	public String index(Model model) {
		List<Anime> animes = animeService.allAnimes();
		model.addAttribute("animes", animes);
		return "index.jsp";
	}
	
	@GetMapping("/animes/new")
	public String newAnime(@ModelAttribute("anime") Anime anime) {
		return "new.jsp";
	}
	@PostMapping("/animes")
	public String create(@Valid @ModelAttribute("anime")Anime anime, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else {
			animeService.createAnime(anime);
			return "redirect:/animes";
		}
	}
	@GetMapping("/search")
	public String search() {
		return "search.jsp";
	}
	@PostMapping("/search")
	public String search(@RequestParam("title") String title, Model viewModel) {
	viewModel.addAttribute("animes", this.animeService.searchAnime(title));
	viewModel.addAttribute("title", title);
	return "search.jsp";
	}
	
	@GetMapping("/animes/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Anime thisAnime = animeService.findAnime(id);
		model.addAttribute("anime", thisAnime);
		return "edit.jsp";
	}
	
	@PostMapping("/animes/edit/{id}")
	public String update(@Valid @ModelAttribute("anime") Anime anime, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			animeService.updateAnime(anime);
			return "redirect:/animes";
		}
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.animeService.deleteAnime(id);
		return "redirect:/animes";
	}
}
