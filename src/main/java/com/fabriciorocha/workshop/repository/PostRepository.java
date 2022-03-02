package com.fabriciorocha.workshop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fabriciorocha.workshop.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{

	List<Post> findByTitleContainingIgnoreCase(String title);
	
	@Query("{ title: { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String title);
}
