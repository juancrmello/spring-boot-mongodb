package com.juanmello.springbootmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.juanmello.springbootmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
