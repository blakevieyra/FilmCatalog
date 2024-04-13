package com.skilldistillery.bootmvc.data;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpavideostore.entities.Customer;
import com.skilldistillery.jpavideostore.entities.Film;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

//spring creates a instance bean allowing a autoowire to occur. Transaction takes care of the entity manager begin , commit, and close
@Service
@Transactional
public class FilmDAOJpaImpl implements FilmDAO {
	// allows spring to auto-wire an entity manager

	@PersistenceContext
	private EntityManager em;

	//finds a single film by id from the dao
	@Override
	public Film findById(int id) {
		Film foundFilm = em.find(Film.class, id);
		return foundFilm;
	}

	//createQuery find all items that match jpql statement in dao
	@Override
	public List<Film> findAll() {
		String jpql = "SELECT f FROM Film f";
		List<Film> films = em.createQuery(jpql, Film.class).getResultList();
		return films;
	}
}
