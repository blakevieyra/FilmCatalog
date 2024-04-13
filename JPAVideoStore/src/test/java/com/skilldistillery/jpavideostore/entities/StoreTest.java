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

class StoreTest {

	private EntityManager em;
	private static EntityManagerFactory emf;
	private Store store;

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
		store = em.find(Store.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		store = null;
		em.close();
	}
	
	//test that the one to one mapping took place in equals. Null checks too. 
	@Test
	void test_Store_Has_Address() {
		assertNotNull(store);
		assertNotNull(store.getAddress());
		assertEquals("Seattle", store.getAddress().getCity());
		assertEquals("Dutch", store.getStaff().getFirstName());
		assertEquals("LaFever", store.getStaff().getLastName());
	}
	
	@Test
	void test_Store_Has_Customer() {
		assertNotNull(store);
		assertNotNull(store.getCustomers());
		assertTrue(store.getCustomers().size() > 5);
	}
	
	@Test
	void test_Store_Has_Staff() {
		assertNotNull(store);
		assertNotNull(store.getStaffMembers());
		assertTrue(store.getStaffMembers().size() > 5);
	}
	
	@Test
	void test_Store_Has_InventoryItem() {
		assertNotNull(store);
		assertNotNull(store.getInventoryItem());
		assertTrue(store.getInventoryItem().size() > 0);
	}
}
