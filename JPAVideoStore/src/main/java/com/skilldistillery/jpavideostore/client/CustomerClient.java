//package com.skilldistillery.jpavideostore.client;
//
//import com.skilldistillery.jpavideostore.entities.Customer;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//public class CustomerClient {
//
//	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
//		EntityManager em = emf.createEntityManager();
//
//		Customer cust = em.find(Customer.class, 1);
//		System.out.println(cust);
//
//		// No memory leaks...
//		em.close();
//		emf.close();
//	}
//}