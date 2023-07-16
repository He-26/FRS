package com.frs.sakila.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frs.sakila.entity.Actor;
import com.frs.sakila.entity.Film;
import com.frs.sakila.service.ActorService;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

	private ActorService actorService;
	
	@Autowired
	public void setActorService(ActorService actorService) {
		this.actorService = actorService;
	}
	
	//working
	@PostMapping("/post")
	public ResponseEntity<String> addActor(@Valid @RequestBody Actor actor) {
		actorService.addActor(actor);
		return new ResponseEntity<>("Record Created Successfully", HttpStatus.CREATED);
	}
	
	//working
	@GetMapping("/lastname/{ln}")
	public ResponseEntity<List<Actor>> searchActorsByLastName(@PathVariable String ln) {
		List<Actor> actors =  actorService.findActorsByLastName(ln);
		return new ResponseEntity<>(actors,HttpStatus.OK);
	}

	//working
	@GetMapping("/firstname/{fn}")
	public ResponseEntity<List<Actor>> searchActorsByFirstName(@PathVariable String fn) {
		List<Actor> actors = actorService.findActorsByFirstName(fn);
		return new ResponseEntity<>(actors,HttpStatus.OK);
	}
	
	//working
	@PutMapping("/update/lastname/{id}")
	public Actor updateActorLastName(@PathVariable("id") Short id,@RequestBody String ln) {
		return actorService.updateActorLastName(id,ln);
	}
	
	//working
	@PutMapping("/update/firstname/{id}")
	public Actor updateActorFirstName(@PathVariable("id") Short id,@RequestBody String fn) {
		return actorService.updateActorFirstName(id, fn);
	}
	
	//working
	@GetMapping("/{id}/films")
	public ResponseEntity<List<Film>> getFilmsByActorId(@PathVariable("id") Short actorId) {
      List<Film> films = actorService.getFilmsByActorId(actorId);
      if (films.isEmpty())
          return ResponseEntity.notFound().build();
      return ResponseEntity.ok(films);
	}
	
	//working
	@GetMapping("/toptenbyfilmcount")
	public List<Object[]> getTopTenActorsByFilmCount() {
		return actorService.getTopTenActorsByFilmCount();
	}
	
	//working
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String> deleteProduct(@PathVariable Short id){
		actorService.deleteActor(id);
		return new ResponseEntity<String>("Id:"+id+" Deleted Successfully!",HttpStatus.OK);		
	}
	
}
