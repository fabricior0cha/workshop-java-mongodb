package com.fabriciorocha.workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fabriciorocha.workshop.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
