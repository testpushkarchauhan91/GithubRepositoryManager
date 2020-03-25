package com.authentication.jwt.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.entities.AuthenticationBean;
import com.authentication.entities.RegisteredUserLogs;
import com.authentication.jms.rabbitmq.MessageReceiver;
import com.authentication.jwt.config.JwtTokenUtil;
import com.authentication.jwt.model.JwtRequest;
import com.authentication.jwt.model.JwtResponse;
import com.authentication.service.RegisteredUserLogsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@Autowired
	private RegisteredUserLogsService registeredUserLogsService;
	
	@Autowired
	MessageReceiver messageReceiver;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		String messageFromQueue = "";

		messageFromQueue = messageReceiver.receiveMessagesFromQueue();

		if (messageFromQueue != null) {
			for (int i = 0; i < 10; i++) {
				System.out.println("=====================================");
			}
			System.out.println("Received Message : " + messageFromQueue + " From RabbitMQ with size : "
					+ messageFromQueue.length());
			for (int i = 0; i < 10; i++) {
				System.out.println("=====================================");
			}
			String[] message = messageFromQueue.split(" ");
			authenticationRequest.setUsername(message[0]);
			authenticationRequest.setPassword(message[1]);
		} else {
			for (int i = 0; i < 10; i++) {
				System.out.println("=====================================");
			}
			System.out.println("Receiving username and password from Authentication Request");
			System.out.println(authenticationRequest.getUsername() + " " + authenticationRequest.getPassword());
			for (int i = 0; i < 10; i++) {
				System.out.println("=====================================");
			}
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("=====================================");
		}
		System.out.println("Receiving username and password from Authentication Request");
		System.out.println(authenticationRequest.getUsername() + " " + authenticationRequest.getPassword());
		for (int i = 0; i < 10; i++) {
			System.out.println("=====================================");
		}

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		RegisteredUserLogs registeredUserLogs = new RegisteredUserLogs();

		// BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// String encodedPassword = encoder.encode("password");

		// since we are overriding the password entered by user by "password"
		// encoded string hence it is allowing us to login
		// encodedPassword (encoder.encode("password")) is different and what we are
		// checking for
		// ($2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6) is different

		List<RegisteredUserLogs> users = new ArrayList<RegisteredUserLogs>();
		users = registeredUserLogsService.getAllUsers();

		boolean flag = false;

		for (RegisteredUserLogs user : users) {
			System.out.println(user.getUsername() + " " + authenticationRequest.getUsername());
			if (user.getUsername().equalsIgnoreCase(authenticationRequest.getUsername())
					&& user.getPassword().equals(authenticationRequest.getPassword())) {
				flag = true;
				break;
			} else {

			}
		}
		if (!flag) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String encodedPassword = "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6";
			registeredUserLogs.setId(users.size() + 1);
			registeredUserLogs.setPassword(encodedPassword);
			registeredUserLogs.setUsername(authenticationRequest.getUsername());
			registeredUserLogs.setToken(token);
			registeredUserLogs.setTimestamp(timestamp);
			registeredUserLogsService.saveUser(registeredUserLogs);
		}

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
