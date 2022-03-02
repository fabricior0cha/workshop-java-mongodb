package com.fabriciorocha.workshop.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fabriciorocha.workshop.entities.Post;
import com.fabriciorocha.workshop.resources.util.URL;
import com.fabriciorocha.workshop.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping("/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title){
		
		title = URL.decodeParam(title);
		List<Post> posts = service.findByTitle(title);
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping("/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value = "title", defaultValue = "") String title,
			@RequestParam(value ="minDate", defaultValue = "") String minDate,
			@RequestParam(value ="maxDate", defaultValue = "") String maxDate){
		
		title = URL.decodeParam(title);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> posts = service.fullSearch(title, min, max);
		return ResponseEntity.ok().body(posts);
	}
	
	
	
}
