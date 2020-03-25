package com.comment.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.comment.model.Comment;

@Repository
public interface CommentDao extends MongoRepository<Comment, Integer> {
	
	
	@Query("{'favourite_items_id' : ?0}")
	List<Comment> findByFavouriteItemsId(int id);
	

}