package com.favourite.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.favourite.model.User;

@FeignClient(name = "PROFILE-SERVICE")
public interface ProfileClient {

	@GetMapping("/user/")
	public List<User> getAllUsers();
}
