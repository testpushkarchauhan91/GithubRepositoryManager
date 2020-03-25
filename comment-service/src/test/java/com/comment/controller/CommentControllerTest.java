package com.comment.controller;

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

import com.comment.model.Comment;
import com.comment.service.CommentServiceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
public class CommentControllerTest{

	private MockMvc mockMvc;

	@Mock
	private CommentServiceimpl service;

	@InjectMocks
	private CommentController controller;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testGetAll() throws Exception {
		mockMvc.perform(get("/comment/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn()
				.equals(new Comment(1, 101, "Google", "http://api.google.com", "Google Comment"));

	}

	@Test
	public void testGetById() throws Exception {
		mockMvc.perform(get("/comment/1/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn()
				.equals(new Comment(1, 101, "Google", "http://api.google.com", "Google Comment"));
	}

	@Test
	public void testCreateFavourite() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/comment/")
				.content(asJsonString(new Comment(1, 101, "Google", "http://api.google.com", "Google Comment")))
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
		mockMvc.perform(MockMvcRequestBuilders.put("/comment/{id}/", 2)
				.content(asJsonString(new Comment(1, 101, "Google", "http://api.google.com", "Google Comment")))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void testDeleteAllFavourite() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/comment/").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void testDeleteFavourite() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/comment/{id}/",1).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());
	}

}
