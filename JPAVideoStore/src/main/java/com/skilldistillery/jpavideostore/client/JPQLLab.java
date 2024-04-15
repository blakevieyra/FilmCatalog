//package com.skilldistillery.jpavideostore.client;
//
//import java.util.List;
//
//import com.skilldistillery.jpavideostore.entities.Customer;
//import com.skilldistillery.jpavideostore.entities.Film;
//import com.skilldistillery.jpavideostore.entities.Staff;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//public class JPQLLab {
//
//	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
//
//	public List<Customer> getRangeOfCustomers(int minId, int maxId) {
//
//		List<Customer> customers = null;
//		EntityManager em = emf.createEntityManager();
//		
//		String jpql = "SELECT c FROM Customer c WHERE c.id BETWEEN :minId AND :maxId";
//		customers = em.createQuery(jpql, Customer.class)
//				.setParameter("minId", minId)
//				.setParameter("maxId", maxId)
//				.getResultList();
//		em.close();
//		return customers;
//	}
//
//	public List<Customer> getCustomerEmailByName(String firstName) {
//
//		List<Customer> customers = null;
//		EntityManager em = emf.createEntityManager();
//		
//		String jpql = "SELECT c.email FROM Customer c WHERE c.first_name = :bind";
//		customers = em.createQuery(jpql, Customer.class)
//				.setParameter("bind", firstName)
//				.getResultList();
//		em.close();
//		return customers;
//	}
//
//	public Film getFilmByTitle(String title) {
//
//		Film film = null;
//		EntityManager em = emf.createEntityManager();
//		
//		try {
//			String jpql = "SELECT f FROM Film f WHERE f.title = :bind";
//			film = em.createQuery(jpql, Film.class)
//					.setParameter("bind", title).getSingleResult();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		em.close();
//		return film;
//	}
//	
//	public Staff getActiveStaffByUsername(String username) {
//
//		Staff staff = null;
//		EntityManager em = emf.createEntityManager();
//		
//		try {
//			String jpql = "SELECT s FROM Staff s WHERE s.active = true AND s.username = :bind";
//			
//			staff = em.createQuery(jpql, Staff.class)
//					.setParameter("bind", username)
//					.getSingleResult();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		em.close();
//		return staff;
//	}
//}
