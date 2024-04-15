//package com.skilldistillery.jpavideostore.client;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.skilldistillery.jpavideostore.entities.Customer;
//import com.skilldistillery.jpavideostore.entities.Film;
//import com.skilldistillery.jpavideostore.entities.Staff;
//
//class JPQLTest {
//	private JPQLLab lab = new JPQLLab();
//
//	@BeforeEach
//	void setUp() throws Exception {
//		lab = new JPQLLab();
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//		lab = null;
//	}
//
//	@Test
//	void test_getRangeOfCustomers() {
//		assertNotNull(lab);
//		List<Customer> results = lab.getRangeOfCustomers(5, 10);
//		assertTrue(!results.isEmpty());
//		assertTrue(results.size() > 0);
//		assertTrue(results.size() <= 100);
//
//	}
//	
//	@Test
//	void test_getCustomerEmailByName() {
//		assertNotNull(lab);
//		List<Customer> results = lab.getCustomerEmailByName("Mary");
//		assertTrue(!results.isEmpty());
//		assertTrue(results.size() > 0);
//		
//	}
//	
//	@Test
//	void test_getFilmByTitle() {
//		assertNotNull(lab);
//		Film result = lab.getFilmByTitle("ACADEMY DINOSAUR");
//		assertEquals("ACADEMY DINOSAUR", result.getTitle());
//	}
//	
//	@Test
//	void test_getActiveStaffByUsername() {
//		assertNotNull(lab);
//		Staff result = lab.getActiveStaffByUsername("aaurand");
//		assertEquals("aaurand", result.getUsername());
//	}
//}
