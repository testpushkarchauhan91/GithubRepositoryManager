package com.favourite.controller.feign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.favourite.model.User;
import com.favourite.feignClient.ProfileClient;

@RestController
@CrossOrigin
public class FavouriteFeignController {

	@Autowired
	ProfileClient profileClient;
	
	@GetMapping("/getAllUsers/")
	public List<User> getAllUsers(){
		return profileClient.getAllUsers();
	}
	
}
// Feign    : http://localhost:8082/getAllUsers/
// Original : http://localhost:8083/user/
