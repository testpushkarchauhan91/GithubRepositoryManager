package com.profile.controller;

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

import com.profile.model.User;
import com.profile.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService service;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping(value= "/user/")
	public void createUser(@RequestBody User user) {
		logger.debug("Saving user.");
		try {
			service.createUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to save users in the db.
	 * @param usre
	 * @return
	 */
	@PostMapping(value= "/users/")
	public void createUsers(@RequestBody List<User> user) {
		logger.debug("Saving users.");
		service.createUsers(user);
	}

	/**
	 * Method to fetch all users from the db.
	 * @return
	 */
	@GetMapping(value= "/user/")
	public List<User> getAllUsers() {
		logger.debug("Getting all users.");
		return service.getAllUsers();
	}

	/**
	 * Method to fetch user by id.
	 * @param id
	 * @return
	 */
	@GetMapping(value= "/user/{userId}/")
	public Optional<User> getById(@PathVariable(value= "userId") int id) {
		logger.debug("Getting user with userId= {}.", id);
		return service.findUserById(id);
	}

	/**
	 * Method to update user by id.
	 * @param id
	 * @param e
	 * @return
	 */
	@PutMapping(value= "/user/{userId}/")
	public String update(@PathVariable(value= "userId") int id, @RequestBody User u) {
		logger.debug("Updating user with userId= {}.", id);
		u.setId(id);
		service.updateUser(u);
		return "User record for userId= " + id + " updated.";
	}

	/**
	 * Method to delete user by id.
	 * @param id
	 * @return
	 */
	@DeleteMapping(value= "/user/{userId}/")
	public void delete(@PathVariable(value= "userId") int id) {
		logger.debug("Deleting user with userId= {}.", id);
		service.deleteUserById(id);
	}

	/**
	 * Method to delete all users from the db.
	 * @return
	 */
	@DeleteMapping(value= "/user/")
	public void deleteAll() {
		logger.debug("Deleting all users.");
		service.deleteAllUsers();
	}
}