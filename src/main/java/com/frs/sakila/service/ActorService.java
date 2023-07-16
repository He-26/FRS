package com.frs.sakila.service;

import java.util.Collection;
import java.util.List;

import com.frs.sakila.entity.Actor;
import com.frs.sakila.entity.Film;

public interface ActorService {
	
	List<Actor> findActorsByLastName(String lastName);
	List<Actor> findActorsByFirstName(String firstName);
	List<Actor> findAllActors();
	public Actor getActor(Short id);
	Actor addActor(Actor actor);
	List<Object[]> getTopTenActorsByFilmCount();
	Actor updateActorFirstName(Short id, String fn);
	Actor updateActorLastName(Short id, String ln);
	List<Film> getFilmsByActorId(Short actorId);
	void deleteActor(Short id);
   
}
