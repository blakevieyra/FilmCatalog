//package com.skilldistillery.jpavideostore.client;
//
//import java.util.List;
//
//import com.skilldistillery.jpavideostore.entities.Address;
//import com.skilldistillery.jpavideostore.entities.Customer;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//public class CRUDClient {
//	
//	
//	public static void main(String[] args) {
////		updateNullEmails();
////		addNewAddress();
//		deleteAddress(100);
//	}
//	
//	
//	public static void deleteAddress(int id) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
//		EntityManager em = emf.createEntityManager();
//		Address a = em.find(Address.class, id);
//		
//		em.getTransaction().begin();
//		em.remove(a);
//		em.getTransaction().commit();
//		
//		
//		em.close();
//		emf.close();
//		
//	}
//	public static void addNewAddress() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
//		EntityManager em = emf.createEntityManager();
//		
//		Address a = new Address();
//		a.setCity("Denver");
//		a.setPhone("8675309");
//		a.setStreet("123 abc street");
//		a.setPostalCode("80112");
//		a.setState("Colorado");
//		
//		em.getTransaction().begin();
//		em.persist(a);
//		em.getTransaction().commit();
//		
//		em.close();
//		emf.close();
//		
//		System.out.println(a);
//	}
//	public static void updateNullEmails() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
//		EntityManager em = emf.createEntityManager();
//
//		// start the transaction
//		String queryString =  "select c from Customer c where c.email IS NULL OR c.email = \"\"";
//		List<Customer> results = em.createQuery(queryString, Customer.class).getResultList();
//		
//		em.getTransaction().begin();
//		
//		for (Customer customer : results) {
//			String email = customer.getFirst_name() + "." + customer.getLast_name()+ "@sdcustomer.org";
//			customer.setEmail(email);
//		}
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
//
//	}
//}