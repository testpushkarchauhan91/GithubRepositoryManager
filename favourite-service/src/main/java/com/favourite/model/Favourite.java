package com.favourite.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Mongo database annotation.
@Document(collection= "favourite")
public class Favourite implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String favourite_items_name;
	private String favourite_items_html_url;
	
	public Favourite() {}

	public Favourite(int id, String favourite_items_name, String favourite_items_html_url) {
		super();
		this.id = id;
		this.favourite_items_name = favourite_items_name;
		this.favourite_items_html_url = favourite_items_html_url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Favourite [id=" + id + ", favourite_items_name=" + favourite_items_name + ", favourite_items_html_url="
				+ favourite_items_html_url + "]";
	}
	
}