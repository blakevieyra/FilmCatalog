//package com.skilldistillery.jpavideostore.client;
//
//import java.util.List;
//
//import com.skilldistillery.jpavideostore.entities.Film;
//import com.skilldistillery.jpavideostore.entities.Rental;
//import com.skilldistillery.jpavideostore.entities.Store;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//public class JPQLRelationshipsLab {
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
//	EntityManager em = emf.createEntityManager();
//
//	public List<Store> getStoresByState(String state) {
//		String query = "Select store FROM Store store WHERE store.address.state = :state";
//		List<Store> results = em.createQuery(query, Store.class).setParameter("state", state).getResultList();
//		em.close();
//		return results;
//	}
//
//	public List<Rental> getRentalsForCustomerWithCustomerId(int id) {
//		String query = "Select rental FROM Rental rental JOIN FETCH rental.customer customers WHERE customers.id = :cid";
//		List<Rental> results = em.createQuery(query, Rental.class).setParameter("cid", id).getResultList();
//		em.close();
//		return results;
//	}
//
//	public List<Film> getFilmsFromActorId(int id) {
//		String query = "Select film FROM Film film JOIN FETCH film.actors actors WHERE actors.id = :actorID";
//		List<Film> results = em.createQuery(query, Film.class).setParameter("actorID", id).getResultList();
//		em.close();
//		return results;
//	}
//
//	public int getNumOfFilmeForCategoryWihtName(String name) {
//		em = emf.createEntityManager();
//		String query = "Select film FROM Film film JOIN FETCH film.categories cat WHERE cat.name = :catName";
//		List<Film> results = em.createQuery(query, Film.class).setParameter("catName", name).getResultList();
//		em.close();
//		return results.size();
//	}
//
//}