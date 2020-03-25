package com.comment.controller;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.comment.model.Comment;
import com.comment.service.CommentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping(value= "/api/mongo/emp")
public class CommentController {

	@Autowired
	CommentService service;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to save comments in the db.
	 * @param comment
	 * @return
	 */
	@PostMapping(value= "/comment/")
	public void createComment(@RequestBody Comment comment) {
		logger.debug("Saving comments.");
		service.createComment(comment);
		//return "Comment records created.";
	}
	
	/**
	 * Method to save comments in the db.
	 * @param comment
	 * @return
	 */
	@PostMapping(value= "/comments/")
	public String createComments(@RequestBody List<Comment> comment) {
		logger.debug("Saving comments.");
		service.createComments(comment);
		return "Comment records created.";
	}

	/**
	 * Method to fetch all comments from the db.
	 * @return
	 */
	@GetMapping(value= "/comment/")
	public List<Comment> getAll() {
		logger.debug("Getting all comments.");
		return service.getAllComments();
	}

	/**
	 * Method to fetch comment by id.
	 * @param id
	 * @return
	 */
	/*
	 * @GetMapping(value= "/comment/{commentId}/") public Optional<Comment>
	 * getById(@PathVariable(value= "commentId") int id) {
	 * logger.debug("Getting comment with commentId= {}.", id); return
	 * service.findCommentById(id); }
	 */

	/**
	 * Method to update comment by id.
	 * @param id
	 * @param e
	 * @return
	 */
	@PutMapping(value= "/comment/{commentId}/")
	public void update(@PathVariable(value= "commentId") int id, @RequestBody Comment c) {
		logger.debug("Updating comment with commentId= {}.", id);
		c.setId(id);
		service.updateComment(c);
		//return "Comment record for commentId= " + id + " updated.";
	}

	/**
	 * Method to delete comment by id.
	 * @param id
	 * @return
	 */
	/*@DeleteMapping(value= "/comment/{commentId}/")
	public String delete(@PathVariable(value= "commentId") int id) {
		logger.debug("Deleting comment with commentId= {}.", id);
		service.deleteCommentById(id);
		return "Comment record for commentId= " + id + " deleted.";
	}*/
	
	@DeleteMapping(value= "/comment/{commentId}/", produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String delete(@PathVariable(value= "commentId") int id) {
		logger.debug("Deleting comment with commentId= {}.", id);
		service.deleteCommentById(id);
		return "Comment record for commentId= " + id + " deleted.";
	}
	
	@GetMapping(value= "/comment/{favouriteId}/")
	public List<Comment> getByfavouriteItemsId(@PathVariable(value= "favouriteId") int id) {
		logger.debug("Getting comment with favouriteId= {}.", id);
		return service.findByFavouriteItemsId(id);
	}
	
	

	/**
	 * Method to delete all comments from the db.
	 * @return
	 */
	@DeleteMapping(value= "/comment/")
	public String deleteAll() {
		logger.debug("Deleting all comments.");
		service.deleteAllComments();
		return "All comments records deleted.";
	}
}