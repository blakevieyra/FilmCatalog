package com.skilldistillery.jpavideostore.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class InventoryItemTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private InventoryItem invItem;
	
	
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
	    invItem = em.find(InventoryItem.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
	    em.close();
	    invItem = null;
	}
	@Test
	void test_entity_mapping() {
		assertNotNull(invItem);
		assertEquals(MediaCondition.Used, invItem.getMediaCondition());
	}
	
	@Test
	void test_InventoryItem_has_Film() {
		assertNotNull(invItem);
		assertEquals("ACADEMY DINOSAUR", invItem.getFilm().getTitle());
	}
	
	@Test
	void test_InventoryItem_has_Store() {
		assertNotNull(invItem);
		assertNotNull(invItem.getStore());
	}
	
	@Test
	void test_Inventory_Item_has_Rental() {
		assertNotNull(invItem);
		assertEquals(3,invItem.getRentals().size());
	
	}

}