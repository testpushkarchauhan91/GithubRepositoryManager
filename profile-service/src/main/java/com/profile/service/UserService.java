package com.profile.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.profile.model.User;

public interface UserService {

	/**
	 * Method to create new user in the db using mongo-db repository.
	 * @param user
	 * @throws Exception 
	 */
	public void createUser(User user) throws Exception;
	
	/**
	 * Method to create new users in the db using mongo-db repository.
	 * @param user
	 */
	public void createUsers(List<User> user);

	/**
	 * Method to fetch all users from the db using mongo-db repository.
	 * @return
	 */
	public List<User> getAllUsers();

	/**
	 * Method to fetch user by id using mongo-db repository.
	 * @param id
	 * @return
	 */
	public Optional<User> findUserById(int id);

	/**
	 * Method to delete user by id using mongo-db repository.
	 * @param id
	 */
	public void deleteUserById(int id);

	/**
	 * Method to update user by id using mongo-db repository.
	 * @param id
	 */
	public void updateUser(User user);

	/**
	 * Method to delete all users using mongo-db repository.
	 */
	public void deleteAllUsers();
}