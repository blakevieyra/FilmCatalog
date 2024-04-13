package com.skilldistillery.bootmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.bootmvc.data.FilmDAO;
import com.skilldistillery.jpavideostore.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDAO;

	// spring auto wires the home page to the jsp page in the WEB-INF folder
	@GetMapping({ "", "/", "home.do" })
	public String index(Model model) {
		List<Film> films = filmDAO.findAll();
		model.addAttribute("films", films);
		return "home";
	}

	// form request controller method, controller get requests, route must match
	// form action name. Create film object add to view. Inject model object as
	// param, spring uses model to add attribute.Can command object instead of
	// Request param: Film film if getter match.

	// this handle the user post request when filmId is entered into searchbar and
	// return film info from
	// home jsp to sho
	@PostMapping(path = "getFilm.do", params = "filmId")
	public String getFilmById(@RequestParam("filmId") int id, Model model) {
		Film film = filmDAO.findById(id);
		model.addAttribute("film", film);
		return "film/show";
	}

	// this handle the href get request from home jsp when user click on the title
	// link
	@GetMapping(path = "getFilm.do", params = "filmId")
	public String getAllFilms(@RequestParam("filmId") int id, Model model) {
		Film film = filmDAO.findById(id);
		model.addAttribute("film", film);
		return "film/show";
	}

}
