package com.profile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profile.dao.UserDao;
import com.profile.jms.rabbitmq.MessageSender;
import com.profile.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	@Autowired
	MessageSender messageSender;

	@Override
	public void createUser(User user) throws Exception {
		dao.save(user);
		sendUsernameAndPasswordToRabbitmq(user);
	}

	public void sendUsernameAndPasswordToRabbitmq(User user) throws Exception {
		// Passing the username and password to rabbitmq
		String username = user.getName();
		String password = user.getPassword();

		for (int i = 0; i < 10; i++) {
			System.out.println("=====================================");
		}
		System.out.println("Sending username and password to Rabbitmq");
		System.out.println(username + " " + password);
		for (int i = 0; i < 10; i++) {
			System.out.println("=====================================");
		}

		// Passing the username and password to rabbitmq
		messageSender.sendMessage(username, password);

	}

	@Override
	public void createUsers(List<User> user) {
		dao.saveAll(user);
	}

	@Override
	public List<User> getAllUsers() {
		return dao.findAll();
	}

	@Override
	public Optional<User> findUserById(int id) {
		return dao.findById(id);
	}

	@Override
	public void deleteUserById(int id) {
		dao.deleteById(id);
	}

	@Override
	public void updateUser(User user) {
		dao.save(user);
	}

	@Override
	public void deleteAllUsers() {
		dao.deleteAll();
	}
}