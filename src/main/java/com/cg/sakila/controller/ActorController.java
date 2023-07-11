package com.cg.sakila.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sakila.entity.Actor;
import com.cg.sakila.entity.Film;
import com.cg.sakila.service.ActorService;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

	private ActorService actorService;
	
	@Autowired
	public void setActorService(ActorService actorService) {
		this.actorService = actorService;
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> addActor(@Valid @RequestBody Actor actor) {
		actorService.addActor(actor);
		return new ResponseEntity<>("Record Created Successfully", HttpStatus.CREATED);
	}
	
	//working
	@GetMapping("/lastname/{ln}")
	public ResponseEntity<List<Actor>> searchActorsByLastName(@PathVariable String ln) {
		List<Actor> actors = (List<Actor>) actorService.findActorsByLastName(ln);
		return new ResponseEntity<>(actors,HttpStatus.OK);
	}

	//working
	@GetMapping("/firstname/{fn}")
	public ResponseEntity<List<Actor>> searchActorsByFirstName(@PathVariable String fn) {
		List<Actor> actors = (List<Actor>) actorService.findActorsByFirstName(fn);
		return new ResponseEntity<>(actors,HttpStatus.OK);
	}
	
	@PutMapping("/update/lastname/{id}")
	public Actor updateActorLastName(@PathVariable("id") Short id,@RequestBody Actor actor) {
		return actorService.updateActorLastName(id,actor);
	}
	
	@PutMapping("/update/firstname/{id}")
	public Actor updateActorFirstName(@PathVariable("id") Short id,@RequestBody Actor actor) {
		return actorService.updateActorFirstName(id, actor);
	}
	
	@GetMapping("/{id}/films")
	public ResponseEntity<List<Film>> getFilmsByActorId(@PathVariable("id") Short actorId) {
      List<Film> films = actorService.getFilmsByActorId(actorId);
      if (films.isEmpty())
          return ResponseEntity.notFound().build();
      return ResponseEntity.ok(films);
	}
	
	@GetMapping("/toptenbyfilmcount")
	public List<Object[]> getTopTenActorsByFilmCount() {
		return actorService.getTopTenActorsByFilmCount();
	}
	
}
