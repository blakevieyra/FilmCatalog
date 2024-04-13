package com.skilldistillery.videostorerest.services;

import java.util.List;

import com.skilldistillery.jpavideostore.entities.Actor;
import com.skilldistillery.jpavideostore.entities.Film;
import com.skilldistillery.jpavideostore.entities.Language;
import com.skilldistillery.jpavideostore.entities.Rating;

public interface FilmService {

	List<Film> findAll();

	Film findById(int id);

	Film create(Film film);

	Film update(int id, Film film);

	boolean delete(int id);
	
	List<Actor> getFilmActors(int filmId);
	
	List<Film> findFilmByKeyword(String keyword);
	
	List<Film> findFilmByLanguage(Language language);

	
	List<Film> findFilmByRating(Rating rating);

	
	List<Film> findFilmByBetweenRentalRateandRentalRate(double rentalRate1, double rentalRate2);
	
	List<Film> findFilmByReplacementPrice(double replacementPrice1, double replacementPrice2);

}
