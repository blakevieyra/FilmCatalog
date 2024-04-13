package com.skilldistillery.videostorerest.data;

import java.util.List;

import com.skilldistillery.jpavideostore.entities.Film;

public interface FilmDAO {

	List<Film> findAll();

	Film filmById(int id);

	Film createFilm(Film film);
}
