//package com.skilldistillery.jpavideostore.client;
//
//import com.skilldistillery.jpavideostore.entities.Film;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//public class FilmClient {
//	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
//		EntityManager em = emf.createEntityManager();
//
//		Film film = em.find(Film.class, 1);
//		System.out.println(film);
//
//		// No memory leaks...
//		em.close();
//		emf.close();
//	}
//}