package com.skilldistillery.videostorerest.services;

import java.util.List;

import com.skilldistillery.jpavideostore.entities.Language;

public interface LanguageService {

	List<Language> findAll();
}
