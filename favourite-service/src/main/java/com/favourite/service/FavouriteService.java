package com.favourite.service;

import java.util.List;
import java.util.Optional;

import com.favourite.model.Favourite;

public interface FavouriteService {

	/**
	 * Method to create new favourites in the db using mongo-db repository.
	 * @param favourite
	 */
	public void createFavourite(Favourite favourite);
	
	/**
	 * Method to create new favourites in the db using mongo-db repository.
	 * @param favourite
	 */
	public void createFavourites(List<Favourite> favourite);

	/**
	 * Method to fetch all favourites from the db using mongo-db repository.
	 * @return
	 */
	public List<Favourite> getAllFavourites();

	/**
	 * Method to fetch favourite by id using mongo-db repository.
	 * @param id
	 * @return
	 */
	public Optional<Favourite> findFavouriteById(int id);

	/**
	 * Method to delete favourite by id using mongo-db repository.
	 * @param id
	 */
	public void deleteFavouriteById(int id);

	/**
	 * Method to update favourite by id using mongo-db repository.
	 * @param id
	 */
	public void updateFavourite(Favourite favourite);

	/**
	 * Method to delete all favourites using mongo-db repository.
	 */
	public void deleteAllFavourites();
	
}