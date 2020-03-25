package com.comment.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.comment.model.Comment;

public interface CommentService {

	/**
	 * Method to create new comments in the db using mongo-db repository.
	 * @param emp
	 */
	public void createComment(Comment comment);
	
	/**
	 * Method to create new comments in the db using mongo-db repository.
	 * @param emp
	 */
	public void createComments(List<Comment> comment);

	/**
	 * Method to fetch all comments from the db using mongo-db repository.
	 * @return
	 */
	public List<Comment> getAllComments();

	/**
	 * Method to fetch comment by id using mongo-db repository.
	 * @param id
	 * @return
	 */
	public Optional<Comment> findCommentById(int id);

	/**
	 * Method to delete employee by id using mongo-db repository.
	 * @param id
	 */
	public void deleteCommentById(int id);

	/**
	 * Method to update employee by id using mongo-db repository.
	 * @param id
	 */
	public void updateComment(Comment comment);

	/**
	 * Method to delete all employees using mongo-db repository.
	 */
	public void deleteAllComments();
	
	public List<Comment> findByFavouriteItemsId(int id);
}