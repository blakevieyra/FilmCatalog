package com.skilldistillery.videostorerest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jpavideostore.entities.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
	
	List<Language> findAll();

}