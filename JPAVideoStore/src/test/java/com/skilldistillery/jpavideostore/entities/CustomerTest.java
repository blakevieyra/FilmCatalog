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

class CustomerTest {

	private EntityManager em;
	private static EntityManagerFactory emf;
	private Customer customer;

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
		customer = em.find(Customer.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		customer = null;
		em.close();
	}

	@Test
	void test_Customer_entity_mapping() {
		assertNotNull(customer);
		assertEquals("Mary", customer.getFirst_name());
		assertEquals("Smithers", customer.getLast_name());
	}

	@Test
	void test_Customer_timestamp_mapping() {
		assertNotNull(customer);
		assertNotNull(customer.getCreateDate());
		assertNotNull(customer.getLastUpdate());
		assertEquals(2014, customer.getCreateDate().getYear());
		assertEquals(2016, customer.getLastUpdate().getYear());
	}
	
	//test that the one to one mapping took place in equals. Null checks too. 
	@Test
	void test_Customer_Has_Address() {
		assertNotNull(customer);
		assertNotNull(customer.getAddress());
		assertEquals("Sasebo", customer.getAddress().getCity());
		assertEquals("35200", customer.getAddress().getPostalCode());
	}
	@Test
	void test_Customer_Has_Films() {
		assertNotNull(customer);
		assertNotNull(customer.getRentals());
		assertTrue(customer.getRentals().size() > 90);
	
	}
	
	@Test
	void test_Customer_Has_Store() {
		assertNotNull(customer);
		assertNotNull(customer.getStore());
		assertNotNull(customer.getStore().getId());
		
	}

}
