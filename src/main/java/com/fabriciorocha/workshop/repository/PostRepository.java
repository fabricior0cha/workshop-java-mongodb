package com.fabriciorocha.workshop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fabriciorocha.workshop.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{

	List<Post> findByTitleContainingIgnoreCase(String title);
}
