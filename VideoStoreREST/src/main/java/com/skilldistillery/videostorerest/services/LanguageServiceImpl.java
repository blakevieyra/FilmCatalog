package com.skilldistillery.videostorerest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jpavideostore.entities.Language;
import com.skilldistillery.videostorerest.repositories.LanguageRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepo;
	
	@Override
	public List<Language> findAll() {
		return languageRepo.findAll();
	}

}		
