//package com.authentication.basicAuth.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		// Way 1:
//		// http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
//		   
//		// Way 2: (disable csrf except options and authenticate other requests)
//		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest()
//				.authenticated().and().httpBasic();
//	}
//}
