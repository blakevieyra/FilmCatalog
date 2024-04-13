package com.skilldistillery.videostorerest.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpavideostore.entities.Film;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FilmDAOImpl implements FilmDAO {

	@PersistenceContext
	private EntityManager em;

	public List<Film> findAll() {
		String query = "Select f from Film f JOIN FETCH f.actors";
		return em.createQuery(query, Film.class).getResultList();
	}

	@Override
	public Film filmById(int id) {
		return em.find(Film.class, id);
	}

	@Override
	public Film createFilm(Film film) {
		em.persist(film);
		return film;
	}

}
