package com.skilldistillery.bootmvc.data;

import java.util.List;

import com.skilldistillery.jpavideostore.entities.Film;

public interface FilmDAO {
	
	Film findById(int id);
	List<Film> findAll();
}
