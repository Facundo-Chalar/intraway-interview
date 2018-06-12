package com.intraway.fchalar;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzControllerTest {

	@Autowired
	private MockMvc mockMVC;
	
	@Test
	public void maxValueGreaterThanMinShouldReturnError() throws Exception {
		this.mockMVC.perform(get("/fizzbuzz/20/10")).andExpect(status().isBadRequest());
	}
	
	@Test
	public void fizzBuzzShouldReturnOkWithCorrectParams() throws Exception {
		this.mockMVC.perform(get("/fizzbuzz/-3/40")).andExpect(status().isOk());
	}
	
}
