package com.shunya.project2021.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.shunya.project2021.Validators.UserValidator;

@Controller
public class AnimeApi {
	@Autowired
	private AnimeService animeService;
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator uVal;
	
//	@GetMapping("/register")
//	public String registeration(@ModelAttribute("user") User user) {
//		return "regist.jsp";
//	}
//	
//	@PostMapping("/register")
//	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
//		uVal.validate(user, result);
//		if(result.hasErrors()) {
//			return "regist.jsp";
//		} else {
//			uService.registerUser(user);
//			session.setAttribute("user_id", user.getId());
//			return "redirect:/login";
//		}
//	}
//	
	@GetMapping("/login")
	public String loginPage(@ModelAttribute("user") User user) {
		return "login.jsp";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttr, HttpSession session) {
		if(!uService.authenticateUser(email, password)) {
			redirectAttr.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/login";
		} else {
			User user = uService.getByEmail(email);
			session.setAttribute("id", user.getId());
			return "redirect:/animes";
		}
	}
	
	
	
	//Postmap for login 1 exp.
	
//	@PostMapping("/login")
//	public String login(@Valid @ModelAttribute("userToLogin") Long userId, HttpSession session, BindingResult result) {
//		if (result.hasErrors()) {
//			return "login.jsp";
//		}
//		session.setAttribute("userLogin", userId);
//		return "redirect:/animes";
//	}
//	
	
	//postMap for login 2 exp.
	
	
	
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
