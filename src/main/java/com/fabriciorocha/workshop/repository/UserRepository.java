package com.fabriciorocha.workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fabriciorocha.workshop.entities.User;

public interface UserRepository extends MongoRepository<User, String>{

}
