package com.cg.sakila.service;

import com.cg.sakila.entity.Actor;
import com.cg.sakila.entity.Film;

import java.util.Collection;
import java.util.List;

public interface ActorService {
	
	Collection<Actor> findActorsByLastName(String lastName);
	Collection<Actor> findActorsByFirstName(String firstName);
	Collection<Actor> findAllActors();
	public Actor getActor(Short id);
	Actor addActor(Actor actor);
	List<Object[]> getTopTenActorsByFilmCount();
	Actor updateActorFirstName(Short id, String fn);
	Actor updateActorLastName(Short id, String ln);
	List<Film> getFilmsByActorId(Short actorId);
   
}
