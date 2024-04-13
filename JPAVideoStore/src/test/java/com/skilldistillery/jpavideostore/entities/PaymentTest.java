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

class PaymentTest {

	private EntityManager em;
	private static EntityManagerFactory emf;
	private Payment payment;

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
		payment = em.find(Payment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		payment = null;
		em.close();
	}

	@Test
	void test_Payment_Has_Amount() {
		assertNotNull(payment);
		assertTrue(payment.getAmount() > 2.50);
		assertEquals(2014, payment.getPaymentDate().getYear());
	}
//
//	@Test
//	void test_Payment_To_Rental() {
//		assertNotNull(payment);
//		assertNotNull(payment.getRental());
//		assertEquals(76, payment.getRental());
//	}
}
