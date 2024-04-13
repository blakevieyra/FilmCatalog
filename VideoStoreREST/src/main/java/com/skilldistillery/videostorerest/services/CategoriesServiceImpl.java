package com.skilldistillery.videostorerest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jpavideostore.entities.Category;
import com.skilldistillery.jpavideostore.entities.Film;
import com.skilldistillery.videostorerest.repositories.CategoryRepository;
import com.skilldistillery.videostorerest.repositories.FilmRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoryRepository categoryRepository;


	@Autowired
	private FilmRepository filmRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Film> getFilmsByCategory(int categoryId) {
		return filmRepository.findByCategories_Id(categoryId);
	}

	@Override
	public Category getCategoryById(int id) {
		return categoryRepository.findById(id);
	}

}		
