package com.skilldistillery.videostorerest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jpavideostore.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer>{
	List<Actor> findByFilms_Id(int filmId);
}
