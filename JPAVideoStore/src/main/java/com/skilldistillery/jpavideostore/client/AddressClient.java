package com.skilldistillery.jpavideostore.client;

import com.skilldistillery.jpavideostore.entities.Address;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AddressClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();

		Address addr = em.find(Address.class, 5);
		System.out.println(addr);

		// No memory leaks...
		em.close();
		emf.close();
	}

}
