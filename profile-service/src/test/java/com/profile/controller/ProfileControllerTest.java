package com.profile.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.profile.model.User;
import com.profile.service.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileControllerTest {

	private MockMvc mockMvc;

	@Mock
	private UserServiceImpl service;

	@InjectMocks
	private UserController controller;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testGetAll() throws Exception {
		mockMvc.perform(get("/user/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn()
				.equals(new User(1, "Pushkar", "password", "password"));

	}

	@Test
	public void testGetById() throws Exception {
		mockMvc.perform(get("/user/1/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn()
				.equals(new User(1, "Pushkar", "password", "password"));
	}

	@Test
	public void testCreateFavourite() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/user/")
				.content(asJsonString(new User(1, "Pushkar", "password", "password")))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void testUpdateFavourite() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/user/{id}/", 2)
				.content(asJsonString(new User(1, "Pushkar", "password", "password")))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void testDeleteAllFavourite() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/user/").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void testDeleteFavourite() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/user/{id}/", 1).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
