package com.authentication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.entities.RegisteredUserLogs;
import com.authentication.repos.RegisteredUserLogsRepository;

@Service
public class RegisteredUserLogsService {

	@Autowired
	RegisteredUserLogsRepository repository;
	
	public void saveUser(RegisteredUserLogs registeredUser) {
		repository.save(registeredUser);
	}
	
	public List<RegisteredUserLogs> getAllUsers(){
		return repository.findAll();
	}
	
	public RegisteredUserLogs findByUsername(String username) {
		return repository.findByUsername(username);
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	public void deleteByUsername(String username) {
		repository.deleteByUsername(username);
	}
	
	
}
