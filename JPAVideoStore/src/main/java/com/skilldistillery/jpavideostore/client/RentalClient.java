package com.skilldistillery.jpavideostore.client;

import com.skilldistillery.jpavideostore.entities.Rental;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RentalClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();

		Rental rental = em.find(Rental.class, 1);
		System.out.println(rental);

		// No memory leaks...
		em.close();
		emf.close();
	}
}
