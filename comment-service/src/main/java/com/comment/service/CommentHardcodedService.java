package com.comment.service;
//package com.comment.services;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.stereotype.Service;
//
//import com.comment.model.Comment;
//
//@Service
//public class CommentHardcodedService {
//
//	private static List<Comment> comments = new ArrayList();
//	private static int idCounter = 0;
//	
//	static {
//		comments.add(new Comment(201, 1, "Facebook", "http://www.api.facebook.com", "Comments For Facebook"));
//		comments.add(new Comment(202, 2, "Twitter", "http://www.api.twitter.com", "Comments For Twitter"));
//		comments.add(new Comment(203, 3, "Linkedin", "http://www.api.linkedin.com", "Comments For Linkedin"));
//	}
//	
//	public List<Comment> findAll(){
//		return comments;
//	}
//	
//	public Comment save(Comment comment) {
//		if (comment.getComment_id() == -1 || comment.getComment_id() == 0) {
//			comment.setComment_id(++idCounter);
//			comments.add(comment);
//		} else {
//			deleteById(comment.getComment_id());
//			comments.add(comment);
//		}
//		return comment;
//	}
//	
//	public Comment deleteById(long id) {
//		Comment comment = findById(id);
//		if (comment == null) {
//			return null;
//		}
//		if (comments.remove(comment)) {
//			return comment;
//		}
//
//		return null;
//	}
//	
//	public Comment findById(long id) {
//		for (Comment comment : comments) {
//			if (comment.getComment_id() == id) {
//				return comment;
//			}
//		}
//		return null;
//	}
//}
