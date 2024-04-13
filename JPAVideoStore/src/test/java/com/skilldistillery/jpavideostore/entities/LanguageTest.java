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

class LanguageTest {

	private EntityManager em;
	private static EntityManagerFactory emf;
	private Language language;

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
		language = em.find(Language.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		language = null;
		em.close();
	}

	@Test
	void test_Language_entity_mapping() {
		assertNotNull(language);
		assertEquals("English", language.getName());
		}
	
	@Test
	void test_Language_To_Film() {
		assertNotNull(language);
		assertNotNull(language.getFilms());
		assertTrue(! language.getFilms().isEmpty());
		assertTrue(language.getFilms().size() > 900);
	}
	@Test
	void test_Language_basic_mapping() {
		assertNotNull(language);
		assertEquals("English", language.getName());
	}

}