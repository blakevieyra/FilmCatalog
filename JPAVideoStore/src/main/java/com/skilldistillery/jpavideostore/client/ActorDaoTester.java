package com.skilldistillery.jpavideostore.client;

import com.skilldistillery.jpavideostore.data.ActorDAO;
import com.skilldistillery.jpavideostore.data.ActorDAOImpl;
import com.skilldistillery.jpavideostore.entities.Actor;

public class ActorDaoTester {
	public static void main(String[] args) throws Exception {
		ActorDAO DAOtest = new ActorDAOImpl();
		Actor actor = new Actor();
//		actor.setFirstName("first");
//		actor.setLastName("last");
//		DAOtest.create(actor);
//		System.out.println("Actor created");
		boolean isDetroyed = DAOtest.destroy(203);
		System.out.println(isDetroyed);
		isDetroyed = DAOtest.destroy(204);
		System.out.println(isDetroyed);

	}
}
