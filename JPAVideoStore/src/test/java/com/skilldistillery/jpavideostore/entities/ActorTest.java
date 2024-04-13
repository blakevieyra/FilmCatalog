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

class ActorTest {

	private EntityManager em;
	private static EntityManagerFactory emf;
	private Actor actor;

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
		actor = em.find(Actor.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		actor = null;
		em.close();
	}

	@Test
	void test_Address_entity_mapping() {
		assertNotNull(actor);
		assertEquals("Penelope", actor.getFirstName());
	}
	
	@Test
	void test_Address_to_Films() {
		assertNotNull(actor);
		assertTrue(actor.getFilms().size() > 0);
	}

}
