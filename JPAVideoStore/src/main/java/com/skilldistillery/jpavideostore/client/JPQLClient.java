package com.skilldistillery.jpavideostore.client;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPQLClient {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");

	public static void main(String[] args) {
		JPQLClient jpqlClient = new JPQLClient();
		jpqlClient.launch();
	}

	public void launch() {
		int idValue = 10;
		getInfo(idValue);
	}

	public void getInfo(int value) {
		EntityManager em = emf.createEntityManager();

		int count = 1;
		String jpql = "SELECT weird.firstName, weird.lastName FROM Staff weird WHERE weird.id <= :bindId";
		List<Object[]> results = em.createQuery(jpql, Object[].class).setParameter("bindId", value).getResultList();
		for (Object[] object : results) {
			System.out.println(count + ")" + object[0] + " " + object[1]);
			count++;
		}
		em.close();
		emf.close();
	}
}