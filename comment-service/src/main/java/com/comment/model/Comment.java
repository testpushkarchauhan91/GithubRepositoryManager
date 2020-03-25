package com.comment.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "comment")
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private int favourite_items_id;
	private String favourite_items_name;
	private String favourite_items_html_url;
	private String comment_value;

	public Comment() {}

	public Comment(int id, int favourite_items_id, String favourite_items_name, String favourite_items_html_url,
			String comment_value) {
		super();
		this.id = id;
		this.favourite_items_id = favourite_items_id;
		this.favourite_items_name = favourite_items_name;
		this.favourite_items_html_url = favourite_items_html_url;
		this.comment_value = comment_value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFavourite_items_id() {
		return favourite_items_id;
	}

	public void setFavourite_items_id(int favourite_items_id) {
		this.favourite_items_id = favourite_items_id;
	}

	public String getFavourite_items_name() {
		return favourite_items_name;
	}

	public void setFavourite_items_name(String favourite_items_name) {
		this.favourite_items_name = favourite_items_name;
	}

	public String getFavourite_items_html_url() {
		return favourite_items_html_url;
	}

	public void setFavourite_items_html_url(String favourite_items_html_url) {
		this.favourite_items_html_url = favourite_items_html_url;
	}

	public String getComment_value() {
		return comment_value;
	}

	public void setComment_value(String comment_value) {
		this.comment_value = comment_value;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
