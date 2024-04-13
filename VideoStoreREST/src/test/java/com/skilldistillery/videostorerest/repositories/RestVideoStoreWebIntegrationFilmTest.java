package com.skilldistillery.videostorerest.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.skilldistillery.jpavideostore.entities.Film;
import com.skilldistillery.jpavideostore.entities.Language;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestVideoStoreWebIntegrationFilmTest {

	private static String url = "/api/films";

	@Autowired
	private TestRestTemplate restTest;

	@Test
	public void test_film_list() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> entity = restTest.getForEntity(url, List.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		@SuppressWarnings("unchecked")
		List<Film> films = (List<Film>) entity.getBody();
		assertTrue(films.size() > 0);
	}

	@Test
	public void test_film_retrieve() {
		int filmId = 1;
		ResponseEntity<Film> entity = restTest.getForEntity(url + "/" + filmId, Film.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Film film = (Film) entity.getBody();
		assertNotNull(film);
		assertEquals("test one UPDATED AGAIN", film.getTitle());
	}

	@Test
	public void test_film_retrieve_returns_404_for_invalid_id() {
		int filmId = 999999;
		ResponseEntity<Film> entity = restTest.getForEntity(url + "/" + filmId, Film.class);
		assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
	}

	@Test
	public void test_film_create() {
		Film newFilm = new Film();
		newFilm.setTitle("NEW TEST FILM " + Math.random()); // title is unique
		Language lang = new Language();
		lang.setId(1);
		newFilm.setLanguage(lang);
		ResponseEntity<Film> entity = restTest.postForEntity(url, newFilm, Film.class);
		assertEquals(HttpStatus.CREATED, entity.getStatusCode());
		Film film = (Film) entity.getBody();
		assertNotNull(film);
	}

	@Test
	public void test_film_delete() {
		Film newFilm = new Film();
		newFilm.setTitle("NEW FILM TO DELETE " + Math.random());
		Language lang = new Language();
		lang.setId(1);
		newFilm.setLanguage(lang);
		ResponseEntity<Film> entity = restTest.postForEntity(url, newFilm, Film.class);
		assertEquals(HttpStatus.CREATED, entity.getStatusCode());
		Film film = (Film) entity.getBody();
		assertNotNull(film);
		int idToDelete = film.getId();
		restTest.delete(url + "/" + idToDelete);
		assertEquals(HttpStatus.NOT_FOUND, restTest.getForEntity(url + "/" + idToDelete, Film.class).getStatusCode());
	}

}
