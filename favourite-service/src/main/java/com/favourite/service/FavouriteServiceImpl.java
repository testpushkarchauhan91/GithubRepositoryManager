package com.favourite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.favourite.dao.FavouriteDao;
import com.favourite.model.Favourite;

@Service
public class FavouriteServiceImpl implements FavouriteService {

	// The dao repository will use the Mongodb-Repository to perform the database operations.
	@Autowired
	FavouriteDao dao;

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.FavouriteService#createFavourite(java.util.List)
	 */
	@Override
	public void createFavourite(Favourite favourite) {
		dao.save(favourite);
	}
	
	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.FavouriteService#createFavourite(java.util.List)
	 */
	@Override
	public void createFavourites(List<Favourite> favourite) {
		dao.saveAll(favourite);
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.FavouriteService#getAllFavourites()
	 */
	@Override
	public List<Favourite> getAllFavourites() {
		return dao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.FavouriteService#findFavouriteById(int)
	 */
	@Override
	public Optional<Favourite> findFavouriteById(int id) {
		return dao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.FavouriteService#deleteFavouriteById(int)
	 */
	@Override
	public void deleteFavouriteById(int id) {
		dao.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.FavouriteService#updateFavourite(int)
	 */
	@Override
	public void updateFavourite(Favourite favourite) {
		dao.save(favourite);
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.FavouriteService#deleteAllFavourites()
	 */
	@Override
	public void deleteAllFavourites() {
		dao.deleteAll();
	}
	
}