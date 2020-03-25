package com.favourite.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.favourite.model.Favourite;

@Repository
public interface FavouriteDao extends MongoRepository<Favourite, Integer> {

}