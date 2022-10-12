package com.example.fastcampus.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class HelloWorldTest {
	
	@Autowired
	private HelloWorld helloWorld;
	
	private MockMvc mockMvc;
	@Test
	void HelloWorldTest() {
		//System.out.println("Test");
		System.out.println(helloWorld.HelloWorld());
	}
	
	@Test
	void mockMvcTest() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(helloWorld).build();
		mockMvc.perform(
				MockMvcRequestBuilders.get("/api/Hello")
		).andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Hello World"));
	}
}
