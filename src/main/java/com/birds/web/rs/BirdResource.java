package com.birds.web.rs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.birds.vo.Bird;
import com.birds.web.service.BirdService;

/**
 * Recurso que expone los servicios para gestionar la información sobre aves
 */
@CrossOrigin
@RestController
@RequestMapping("/birdsJava")
public class BirdResource {

	@Autowired
	private BirdService birdService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Bird>> fidAll() {
		return ResponseEntity.ok(birdService.fidAll());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{name}/{zoneName}")
	public ResponseEntity<List<Bird>> findByNameAndZoneName(@PathVariable("name") String name,
			@PathVariable("zoneName") String zoneName) {
		return ResponseEntity.ok(birdService.findByNameAndZoneName(name, zoneName));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity <Bird> findById(@PathVariable("id") String id) {
		Optional<Bird> bird = birdService.findById(id);
		if(bird.isPresent()) {
			return ResponseEntity.ok(bird.get());
		}else {
			return ResponseEntity.ok(new Bird());
		}
		
	}

	

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public	ResponseEntity<Bird> deleteById(@PathVariable("id") String id) {
		birdService.deteleById(id);
		return ResponseEntity.ok(new Bird());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Bird> createBird(@RequestBody Bird bird) {
		birdService.createBird(bird);
		return ResponseEntity.ok(bird);
	}
}
