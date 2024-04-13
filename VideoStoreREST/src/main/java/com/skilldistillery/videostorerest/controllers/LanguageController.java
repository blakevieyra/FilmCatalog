package com.skilldistillery.videostorerest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jpavideostore.entities.Language;
import com.skilldistillery.videostorerest.services.LanguageService;

@RestController
@RequestMapping("api")
public class LanguageController {

	@Autowired
	private LanguageService languageService;

	@GetMapping(path = "languages")
	public List<Language> getLanguages() {
		return languageService.findAll();
	}

}
