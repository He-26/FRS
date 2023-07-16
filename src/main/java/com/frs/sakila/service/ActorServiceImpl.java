package com.frs.sakila.service;

import org.springframework.stereotype.Service;

import com.frs.sakila.entity.Actor;
import com.frs.sakila.entity.Film;
import com.frs.sakila.exception.ActorNotFoundException;
import com.frs.sakila.repository.ActorRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

	private ActorRepository actorRepository;
	
	@Autowired
	public void setActorRepository(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}
	
    @Override
    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Actor addActor(Actor actor) {
    	if(actor.getFirstName().length()<5) {
    		throw new ActorNotFoundException("firstName length should be minimum 5");
    	}else if(actor.getLastName().length()<5) {
    		throw new ActorNotFoundException("lastName length should be minimum 5");
    	}
        return actorRepository.save(actor);
    }
    
    @Override
    public List<Actor> findActorsByLastName(String lastName) {
    	List<Actor> actor = actorRepository.findByLastName(lastName);
    	if(actor.isEmpty())
    		throw new ActorNotFoundException("Actor with Lastname: "+lastName+", is not avialable");
        return actorRepository.findByLastName(lastName);
    }

    @Override
    public List<Actor> findActorsByFirstName(String firstName) {
    	List<Actor> actors=actorRepository.findByFirstName(firstName);
    	if(actors.isEmpty())
    		throw new ActorNotFoundException("Actor with firstName "+firstName+" is not available");
        return actorRepository.findByFirstName(firstName);
    }
    
	@Override
    public Actor updateActorLastName(Short id, String ln) {
		Actor actor = actorRepository.findById(id).orElseThrow(()->new ActorNotFoundException("Actor with ID: "+id+" is not available"));
		if (actor != null) {
			if(actor.getLastName().length()<5)
	    		throw new ActorNotFoundException("lastName length should be minimum 5");
			actor.setLastName(ln);
			return actorRepository.save(actor);
		}
		throw new ActorNotFoundException("Actor with ID: "+id+", is not available");
    }

    @Override
    public Actor updateActorFirstName(Short id, String fn) {
    	Actor actor = actorRepository.findById(id).orElseThrow(()->new ActorNotFoundException("Actor with ID: "+id+" is not available"));
		if (actor != null) {
			if(actor.getFirstName().length()<5)
	    		throw new ActorNotFoundException("firstName length should be minimum 5");
			actor.setFirstName(fn);
			return actorRepository.save(actor);
		}
		throw new ActorNotFoundException("Actor with ID: "+id+",is not available");
    }

	@Override
	public Actor getActor(Short id) {
		return actorRepository.findById(id).orElseThrow(()-> new ActorNotFoundException("Actor with ID: "+id+",is not available"));
	}
    
    @Override
    public List<Object[]> getTopTenActorsByFilmCount() {
    	 List<Object[]> results = actorRepository.findTopTenActorsByFilmCount();
    	 return results.subList(0, 10);
    }

	@Override
	public List<Film> getFilmsByActorId(Short actorId) {
		List<Film> allLists=actorRepository.searchFilmsByActorId(actorId);
		if(allLists.isEmpty())
			throw new ActorNotFoundException("no data available");
		return actorRepository.searchFilmsByActorId(actorId);
	}

	@Override
	public void deleteActor(Short id) {
		Actor actor=getActor(id);
		actorRepository.deleteById(actor.getActorId());
		
	}
    
}
