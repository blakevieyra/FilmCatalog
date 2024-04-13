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

class RentalTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Rental rental;
	
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
	    rental = em.find(Rental.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
	    em.close();
	    rental = null;
	}
	
	@Test
	void test_Rental_to_Staff() {
		assertNotNull(rental);
		assertNotNull(rental.getStaff());
		assertEquals("Tingvold", rental.getStaff().getLastName());
	}
	
	@Test
	void test_Rental_to_Customer() {
		assertNotNull(rental);
		assertNotNull(rental.getCustomer());
		assertEquals("Hunter", rental.getCustomer().getLast_name());
	}

	@Test
	void test_Rental_basic_mappings() {
		assertNotNull(rental);
		assertNotNull(rental);
		assertNotNull(rental.getRentalDate());
		assertNotNull(rental.getReturnDate());
		assertEquals(2014, rental.getRentalDate().getYear());
		assertEquals(2014, rental.getReturnDate().getYear());
	}
	
	@Test
	void test_Rental_has_Inventory_Item() {
		assertNotNull(rental);
		assertNotNull(rental.getInventoryItem());
	}

}