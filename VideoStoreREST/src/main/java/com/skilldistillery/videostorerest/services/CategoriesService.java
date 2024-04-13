package com.skilldistillery.videostorerest.services;

import java.util.List;

import com.skilldistillery.jpavideostore.entities.Category;
import com.skilldistillery.jpavideostore.entities.Film;

public interface CategoriesService {

	List<Category> findAll();
	
	Category getCategoryById(int id);

	List<Film> getFilmsByCategory(int id);
}
