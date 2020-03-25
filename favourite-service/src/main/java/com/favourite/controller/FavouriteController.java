package com.favourite.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.favourite.model.Favourite;
import com.favourite.service.FavouriteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping(value= "/api/mongo/emp")
public class FavouriteController {

	@Autowired
	FavouriteService service;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to save favourites in the db.
	 * 
	 * @param favourite
	 * @return
	 */
	@PostMapping(value = "/favourite/")
	public void createFavourite(@RequestBody Favourite favourite) {
		service.createFavourite(favourite);
	}

	/**
	 * Method to save favourites in the db.
	 * 
	 * @param favourite
	 * @return
	 */
	@PostMapping(value = "/favourites/")
	public void createFavourites(@RequestBody List<Favourite> favourite) {
		logger.debug("Saving favourites.");
		service.createFavourites(favourite);
		// return "Favourite records created.";
	}

	/**
	 * Method to fetch all favourites from the db.
	 * 
	 * @return
	 */
	@GetMapping(value = "/favourite/")
	public List<Favourite> getAll() {
		logger.debug("Getting all favourites.");
		return service.getAllFavourites();
	}

	/**
	 * Method to fetch favourite by id.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/favourite/{favouriteId}/")
	public Optional<Favourite> getById(@PathVariable(value = "favouriteId") int id) {
		logger.debug("Getting favourite with favouriteId= {}.", id);
		return service.findFavouriteById(id);
	}

	/**
	 * Method to update favourite by id.
	 * 
	 * @param id
	 * @param e
	 * @return
	 */
	@PutMapping(value = "/favourite/{favouriteId}/")
	public String update(@PathVariable(value = "favouriteId") int id, @RequestBody Favourite f) {
		logger.debug("Updating favourite with favouriteId= {}.", id);
		f.setId(id);
		service.updateFavourite(f);
		return "Favourite record for favouriteId= " + id + " updated.";
	}

	/**
	 * Method to delete favourite by id.
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/favourite/{favouriteId}/")
	public void delete(@PathVariable(value = "favouriteId") int id) {
		logger.debug("Deleting favourite with favouriteId= {}.", id);
		service.deleteFavouriteById(id);
		// return "Favourite record for favouriteId= " + id + " deleted.";
	}

	/**
	 * Method to delete all favourites from the db.
	 * 
	 * @return
	 */
	@DeleteMapping(value = "/favourite/")
	public void deleteAll() {
		logger.debug("Deleting all favourites.");
		service.deleteAllFavourites();
		// return "All favourite records deleted.";
	}
	
}