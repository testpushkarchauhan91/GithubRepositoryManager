package com.profile.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.profile.model.User;

@Repository
public interface UserDao extends MongoRepository<User, Integer> {

}