package com.comment.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comment.dao.CommentDao;
import com.comment.model.Comment;

@Service
public class CommentServiceimpl implements CommentService {

	// The dao repository will use the Mongodb-Repository to perform the database operations.
	@Autowired
	CommentDao dao;

	/* (non-Javadoc)
	 * @see com.comment.service.CommentService#createComment(java.util.List)
	 */
	@Override
	public void createComment(Comment comment) {
		dao.save(comment);
	}
	
	/* (non-Javadoc)
	 * @see com.comment.service.CommentService#createComment(java.util.List)
	 */
	@Override
	public void createComments(List<Comment> comment) {
		dao.saveAll(comment);
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.Employeeservice#getAllEmployees()
	 */
	@Override
	public List<Comment> getAllComments() {
		return dao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.comment.service.CommentService#findCommentById(int)
	 */
	@Override
	public Optional<Comment> findCommentById(int id) {
		return dao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.comment.service.CommentService#deleteCommentById(int)
	 */
	@Override
	public void deleteCommentById(int id) {
		dao.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.comment.service.CommentService#updateComment(int)
	 */
	@Override
	public void updateComment(Comment comment) {
		dao.save(comment);
	}

	/* (non-Javadoc)
	 * @see com.comment.service.CommentService#deleteAllComments()
	 */
	@Override
	public void deleteAllComments() {
		dao.deleteAll();
	}

	@Override
	public List<Comment> findByFavouriteItemsId(int id) {
		return dao.findByFavouriteItemsId(id);
	}
}