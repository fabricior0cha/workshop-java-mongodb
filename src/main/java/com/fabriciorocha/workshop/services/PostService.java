package com.fabriciorocha.workshop.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabriciorocha.workshop.entities.Post;
import com.fabriciorocha.workshop.repository.PostRepository;
import com.fabriciorocha.workshop.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() ->  new ObjectNotFoundException("Objeto não encontrado."));
	}
	
	public List<Post> findByTitle(String title){
		return repository.searchTitle(title);
	}
	
	public List<Post> fullSearch(String title, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(title, minDate, maxDate);
	}
	
}
