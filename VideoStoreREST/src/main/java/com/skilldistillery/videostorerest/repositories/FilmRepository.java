package com.skilldistillery.videostorerest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jpavideostore.entities.Category;
import com.skilldistillery.jpavideostore.entities.Film;
import com.skilldistillery.jpavideostore.entities.Language;
import com.skilldistillery.jpavideostore.entities.Rating;

public interface FilmRepository extends JpaRepository<Film, Integer> {

	Film searchById(int id);

	Film findByTitle(String title);

	List<Film> findByReleaseYear(int releaseYear);

	long countByReleaseYear(int releaseYear);

	boolean existsByTitle(String title);

	boolean existsByReleaseYear(int releaseYear);

	List<Film> queryByRating(Rating Rating);

	List<Film> queryByLanguage(Language language);

	List<Film> findByTitleLikeOrDescriptionLike(String keyword, String keyword2);

	List<Film> queryByReplacementCostGreaterThanEqualAndReplacementCostLessThanEqual(double min, double max);

	List<Film> queryByReplacementCostBetween(double min, double max);
	
	List<Film> findByCategories_Id(int categoryId);
	
	List<Film> findByRating(Rating Rating);


	
}
