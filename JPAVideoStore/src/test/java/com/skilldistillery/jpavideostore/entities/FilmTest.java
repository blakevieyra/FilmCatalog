package com.skilldistillery.jpavideostore.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class FilmTest {

	private EntityManager em;
	private static EntityManagerFactory emf;
	private Film film;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("VideoStore");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		film = em.find(Film.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		film = null;
		em.close();
	}

	@Test
	void test_Film_entity_mapping() {
		assertNotNull(film);
		assertEquals("ACADEMY DINOSAUR", film.getTitle());
		assertEquals(1993, film.getReleaseYear());
	}

	@Test
	void test_Film_has_rating() {
		assertNotNull(film);
		assertEquals("PG", film.getRating().toString());
		assertTrue(film.getRating().equals(Rating.PG));
	}
	
	@Test
	void test_Film_has_language() {
		assertNotNull(film);
		assertNotNull(film.getLanguage());
		assertEquals("Japanese", film.getLanguage().getName());
		
	}
	
	@Test
	void test_Film_has_Actors() {
		assertNotNull(film);
		assertNotNull(film.getActors());
		assertTrue(film.getActors().size() > 0);
	}
	
	@Test
	void test_Film_has_Categories() {
		assertNotNull(film);
		assertNotNull(film.getCategories());
		assertTrue(film.getCategories().size() > 0);
	}
	
	@Test
	void test_Film_has_InventoryItems() {
		assertNotNull(film);
		assertNotNull(film.getItems());
		assertTrue(film.getItems().size() > 0);
	}

}