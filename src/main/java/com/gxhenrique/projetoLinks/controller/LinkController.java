package com.gxhenrique.projetoLinks.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gxhenrique.projetoLinks.entity.Link;
import com.gxhenrique.projetoLinks.services.LinkService;

@RestController
@RequestMapping(value = "/links")
public class LinkController {
	
	@Autowired
	private LinkService service;
	
	@GetMapping
	public ResponseEntity<List<Link>> findAll(){
		
		List<Link> list = service.fidAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Link> findById(@PathVariable Long id){
		
		Link obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Link> postUser(@RequestBody Link link){
		link = service.postLink(link);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(link.getId()).toUri();
		return ResponseEntity.created(uri).body(link);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Link> putUser(@RequestBody Link link, @PathVariable Long id){
		link = service.putLink(id, link);
		return ResponseEntity.ok().body(link);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Link> patchUser(@RequestBody Link link, @PathVariable Long id){
		link = service.patchLink(id, link);
		return ResponseEntity.ok().body(link);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Link> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
