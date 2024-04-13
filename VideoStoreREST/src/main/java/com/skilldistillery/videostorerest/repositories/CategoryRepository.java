package com.skilldistillery.videostorerest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jpavideostore.entities.Category;
import com.skilldistillery.jpavideostore.entities.Film;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	List<Category> findAll();
	
	Category findById(int id);
}
