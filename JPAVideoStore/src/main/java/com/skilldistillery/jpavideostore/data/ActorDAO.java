package com.skilldistillery.jpavideostore.data;

import com.skilldistillery.jpavideostore.entities.Actor;

public interface ActorDAO {
	public Actor create(Actor actor);

	public boolean destroy(int id);

	public Actor update(int id, Actor actor);
}
