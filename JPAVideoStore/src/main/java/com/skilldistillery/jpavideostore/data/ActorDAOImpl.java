package com.skilldistillery.jpavideostore.data;

import com.skilldistillery.jpavideostore.entities.Actor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ActorDAOImpl implements ActorDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
	private EntityManager em = emf.createEntityManager();

	@Override
	public Actor create(Actor actor) {

		// start the transaction
		em.getTransaction().begin();
		// write the customer to the database
		em.persist(actor);
		// update the "local" Actor actor object
		em.flush();
		// commit the changes (actually perform the operation)
		em.getTransaction().commit();
		emf.close();
		em.close();

		// return the Actor actor object
		return actor;
	}

	@Override
	public Actor update(int id, Actor actor) {
		// start the transaction
		em.getTransaction().begin();

		Actor updated = em.find(Actor.class, id);
		updated.setFirstName(actor.getFirstName());
		updated.setLastName(actor.getLastName());

		em.getTransaction().commit();

		return updated;
	}

	@Override
	public boolean destroy(int id) {

		em.getTransaction().begin();
		Actor a = em.find(Actor.class, id);

		em.remove(a); // performs the delete on the managed entity

		em.getTransaction().commit();

		return em.find(Actor.class, id) == null;

	}

}
