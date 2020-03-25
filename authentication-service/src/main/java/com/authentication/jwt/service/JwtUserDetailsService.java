package com.authentication.jwt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authentication.service.RegisteredUserLogsService;
import com.authentication.utility.ConfigUtility;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	RegisteredUserLogsService registeredUserService;

	@Autowired
	ConfigUtility configUtility;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//		if ("javainuse".equals(username)) {
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		}else if ("pushkar".equals(username)) {
//			return new User("pushkar", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		}else if ("nitesh".equals(username)) {
//			return new User("nitesh", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		}else if ("aman".equals(username)) {
//			return new User("aman", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}

//		for (int i = 0; i < users.size(); i++) {
//			RegisteredUser user = users.get(i);
//			if (user.getUsername().equals(username)) {
//				return new User(username, "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new ArrayList<>());
//			//	return new User(username, user.getPassword(), new ArrayList<>());
//			}
//		}
//
//		throw new UsernameNotFoundException("User not found with username: " + username);

//		List<RegisteredUser> users = registeredUserService.getAllUsers();
//		for (RegisteredUser user : users) {
//			if (user.getUsername() != null) {
//				if (user.getUsername().equals(username)) {
//					return new User(username, configUtility.getPasswordFromPropertyFile(), new ArrayList<>());
//				}
//			}
//		}
		
		
		if (username != null) {
			return new User(username, configUtility.getPasswordFromPropertyFile(), new ArrayList<>());
		}

		throw new UsernameNotFoundException("User not found with username: " + username);
	}

}