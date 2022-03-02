package com.fabriciorocha.workshop.services;

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
	
}
