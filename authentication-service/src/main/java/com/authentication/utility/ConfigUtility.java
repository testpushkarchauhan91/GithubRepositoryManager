package com.authentication.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ConfigUtility {

	@Autowired
	private Environment environment;
	
	public String getPasswordFromPropertyFile() {
		return environment.getProperty("encodedPassword");
	}
}
