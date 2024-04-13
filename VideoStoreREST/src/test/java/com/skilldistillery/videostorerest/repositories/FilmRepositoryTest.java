package com.skilldistillery.videostorerest.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.jpavideostore.entities.Film;
import com.skilldistillery.jpavideostore.entities.Language;
import com.skilldistillery.jpavideostore.entities.Rating;

@SpringBootTest
class FilmRepositoryTest {

	@Autowired
	private FilmRepository filmRepo;

	@Test
	void test_find_By_Title() {
		Film film = filmRepo.findByTitle("ACE GOLDFINGER");
		assertNotNull(film);
		assertEquals(2, film.getId());

	}

	@Test
	void test_find_Films_By_Release_Year() {
		List<Film> films = filmRepo.findByReleaseYear(1999);
		assertNotNull(films);
		assertTrue(films.size() > 0);

	}

	@Test
	void test_Count_Films_By_Release_Year() {
		long count = filmRepo.countByReleaseYear(1999);
		assertTrue(count > 0);
		assertEquals(35, count);

	}

	@Test
	void test_Film_Exists_By_Title() {
		boolean exists = filmRepo.existsByTitle("ACE GOLDFINGER");
		assertTrue(exists);

	}

	@Test
	void test_Film_Exists_By_Release_Year() {
		boolean exists = filmRepo.existsByReleaseYear(1999);
		assertTrue(exists);

	}

	@Test
	void test_Film_By_Rating() {
		List<Film> films = filmRepo.queryByRating(Rating.PG);
		assertNotNull(films);
	}

	@Test
	void test_Film_By_Language() {
		Language language = new Language();
		language.setId(3);
		List<Film> films = filmRepo.queryByLanguage(language);
		assertNotNull(films);
		assertTrue(films.size() > 0);
	}
//
//	@Test
//	void test_Film_By_Language_By_Name() {
//		List<Film> films = filmRepo.queryByLanguage("English");
//		assertNotNull(films);
//		assertTrue(films.size() > 0);
//	}
//
//	@Test
//	void test_Film_By_Language_By_Name_And_ReleaseYear() {
//		List<Film> films = filmRepo.queryByLanguageAndReleaseYear("English", 2000);
//		assertNotNull(films);
//		assertTrue(films.size() > 0);
//	}

	@Test
	void test_Film_By_Language_By_Range_ReplacementCost_And_ReleaseYear() {
		List<Film> films = filmRepo.queryByReplacementCostBetween(9.00, 10.00);
		assertNotNull(films);
		assertTrue(films.size() > 0);
	}

}
