package com.brasil.seg.app;

import com.brasil.seg.app.model.Movie;
import com.brasil.seg.app.service.MoviesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class AppApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MoviesService service;

	//Testando Inclusao Movie
	@Test
	void case1() throws Exception {
		Movie movie = new Movie("Terminator", 2012, "S", "Ação", "En-us" );

		mockMvc.perform(post("/movie")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(movie)))
				.andExpect(status().isOk());

		Movie movieReturned = service.getMovieInfo(movie.getId());

		// JUnit5
		Assertions.assertEquals(movieReturned.getActive(), "S");
		Assertions.assertEquals(movieReturned.getLanguage(), "En-us");
		Assertions.assertEquals(movieReturned.getReleaseYear(), 2012);

	}

}
