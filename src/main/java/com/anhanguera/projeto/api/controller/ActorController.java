package com.anhanguera.projeto.api.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anhanguera.projeto.domain.model.Actor;
import com.anhanguera.projeto.domain.repository.ActorRepository;

@RestController
@RequestMapping("/actor")
public class ActorController {
	
	@Autowired
	private ActorRepository actorRepository;

	@GetMapping
	public List<Actor> findAll(){
		return actorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Actor> findById(@PathVariable Long id){
		return actorRepository.findById(id)
				.map(actor -> ResponseEntity.ok(actor))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Actor add(@RequestBody Actor actor) {
		return actorRepository.save(actor);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Actor> update(@PathVariable Long id, @RequestBody Actor actor){
		if(!actorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		actor.setId(id);
		actorRepository.save(actor);
		return ResponseEntity.ok(actor);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		if(!actorRepository.existsById(id)){
			return ResponseEntity.notFound().build();
		}
		
		actorRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
