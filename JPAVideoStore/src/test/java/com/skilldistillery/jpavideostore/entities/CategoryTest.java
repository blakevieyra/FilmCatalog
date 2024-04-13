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

class CategoryTest {

	private EntityManager em;
	private static EntityManagerFactory emf;
	private Category category;

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
		category= em.find(Category.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		category= null;
		em.close();
	}

	@Test
	void test_Category_entity_mapping() {
		assertNotNull(category);
		assertEquals("Action", category.getName());
	}
	
	@Test
	void test_() {
		assertNotNull(category);
		assertTrue(category.getFilms().size() > 0);
	}

}
