//package com.skilldistillery.jpavideostore.client;
//
//import com.skilldistillery.jpavideostore.entities.Language;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//public class LanguageClient {
//
//	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
//		EntityManager em = emf.createEntityManager();
//
//		Language language = em.find(Language.class, 1);
//		System.out.println(language);
//
//		// No memory leaks...
//		em.close();
//		emf.close();
//	}
//}
