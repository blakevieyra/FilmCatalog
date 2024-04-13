package com.skilldistillery.videostorerest.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpavideostore.entities.Address;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AddressDAOImpl implements AddressDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Address> findAll() {
		String query = "Select a from Address a";
		return em.createQuery(query, Address.class).getResultList();
	}

	@Override
	public Address findById(int id) {
		Address address = em.find(Address.class, id);
		return address;
	}

	@Override
	public Address create(Address address) {
		em.persist(address);
		return address;
	}
}