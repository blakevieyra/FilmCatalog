//package com.skilldistillery.jpavideostore.client;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.skilldistillery.jpavideostore.entities.Film;
//import com.skilldistillery.jpavideostore.entities.Rental;
//import com.skilldistillery.jpavideostore.entities.Store;
//
//class JPQLRelationshipsTests {
//	
//	private JPQLRelationshipsLab lab;
//	
//	@BeforeEach
//	void setUp() throws Exception {
//		lab = new JPQLRelationshipsLab();
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//		lab = null;
//	}
//	
//	@Test
//	void test_State_Has_City() {
//		assertNotNull(lab);
//		List<Store> results = lab.getStoresByState("Washington");
//		assertNotNull(results);
//		assertEquals("Washington", results.get(0).getAddress().getState());
//	}
//	
//	@Test
//	void test_Rental_By_Customer_Id() {
//		assertNotNull(lab);
//		List<Rental> results = lab.getRentalsForCustomerWithCustomerId(1);
//		assertNotNull(results);
//		assertEquals(95, results.size());
//	}
//	
//	@Test
//	void test_Get_Films_By_ActorId() {
//		assertNotNull(lab);
//		List<Film> results = lab.getFilmsFromActorId(1);
//		assertNotNull(results);
//		assertEquals(19, results.size());
//	}
//	
//	@Test
//	void test_Num_Films_By_Category_Name(){
//		assertNotNull(lab);
//		int numFilms = lab.getNumOfFilmeForCategoryWihtName("Comedy");
//		assertEquals(58, numFilms);
//	}
//}