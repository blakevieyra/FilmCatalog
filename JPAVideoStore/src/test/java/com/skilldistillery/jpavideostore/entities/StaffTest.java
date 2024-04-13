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

class StaffTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Staff staff;
	
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
	    staff = em.find(Staff.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
	    em.close();
	    staff = null;
	}

	@Test
	void test_Staff_basic_mappings() {
		assertNotNull(staff);
		assertEquals("Larry", staff.getFirstName());
		assertEquals("Kong", staff.getLastName());
	}
	
	@Test
	void test_Staff_has_Address() {
		assertNotNull(staff);
		assertNotNull(staff.getAddress());
		assertEquals("370 E. Rochelle Blvd", staff.getAddress().getStreet());
	}
	
	@Test
	void test_Staff_has_Store() {
		assertNotNull(staff);
		assertNotNull(staff.getStore());
		assertEquals(4, staff.getStore().getId());
	}
	
	//self join compared columns within itself 
	@Test
	void test_Self_Join_Supervisor() {
		Staff staffMember = em.find(Staff.class, 8);
		assertNotNull(staffMember.getSupervisor());
		assertEquals(64, staffMember.getSupervisor().getId());
	}
	
	@Test
	void test_one_To_many_Supervisees() {
		Staff supervisor = em.find(Staff.class, 1);
		assertNotNull(supervisor.getSupervisees());
		assertTrue(supervisor.getSupervisees().size() > 0);
	}
	

}