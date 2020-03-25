//package com.authentication.basicAuth.controllers;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.authentication.entities.AuthenticationBean;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//public class BasicAuthenticationController {
//
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	
//	@GetMapping("/basicauth")
//	public AuthenticationBean helloWorldBean() {
//		logger.info("Application: authetication-service BasicAuthenticationController helloWorldBean() called...");
//		return new AuthenticationBean("You are authenticated");
//	}
//
//}
