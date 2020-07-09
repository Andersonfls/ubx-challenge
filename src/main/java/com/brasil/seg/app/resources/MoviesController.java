package com.brasil.seg.app.resources;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import com.brasil.seg.app.model.Genre;
import com.brasil.seg.app.model.Language;
import com.brasil.seg.app.model.Movie;
import com.brasil.seg.app.service.MoviesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class MoviesController {

	private static final Logger LOG = LoggerFactory.getLogger(MoviesController.class);

	@Autowired
	private MoviesService moviesService;

	@RequestMapping(value = "/languages", method = RequestMethod.GET)
	public List<Language> getAllLanguages() {
		return moviesService.getAllLanguages();
	}

	@RequestMapping(value = "movies/genres", method = RequestMethod.GET)
	public List<Genre> getAllGenres() {
		return moviesService.getAllGenres();
	}

	// Lista ou seções com os filmes mais populares
	@RequestMapping(value = "/trending", method = RequestMethod.GET)
	public List<Movie> getPopularMovies() {
		LOG.info("Fetch Popular Movie...");
		List<Movie> list = moviesService.getAllMovies();
		LOG.debug(": " + list.size());
		List<Movie> ratedMovies = list.parallelStream().filter(obj -> null != obj.getId())
				.collect(Collectors.toList());
		LOG.debug(": " + ratedMovies.size());
		return ratedMovies;
	}

	/**
	 * GET  /movies/:id : get the "id" movie.
	 *
	 * @param id the id of the movie to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the adjudicacaoDTO, or with status 404 (Not Found)
	 */
	@GetMapping(value = "/movies/{id}")
	public Movie getMovieInfo(@PathVariable("id") Long id) {
		return moviesService.getMovieInfo(id);
	}

	/**
	 * GET  /movies : get all the movies.
	 *
	 * @return the ResponseEntity with status 200 (OK) and the list of movies in body
	 */
	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		LOG.info("Fetch all the Movie...");
		return moviesService.getAllMovies();
	}

	/**
	 * POST  /movie : Create a new adjudicacao.
	 *
	 * @param movie to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new movie, or with status 400 (Bad Request) if the movie has already an ID
	 * @throws URISyntaxException if the Location URI syntax is incorrect
	 */
	@PostMapping("/movie")
	public List<Movie> addMovie(@RequestBody Movie movie) {
		LOG.info("Add a Movie...");
		moviesService.addMovie(movie);
		return moviesService.getAllMovies();
	}

	/**
	 * Delete a movie by id.
	 *
	 * @param id the id of the entity
	 */
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
		LOG.info("Request to delete movie: {}", id);
		moviesService.deleteById(id);
		return ResponseEntity.ok().build();
	}

//	@RequestMapping(value = "/review", method = RequestMethod.POST)
//	public Movie addMovieReview(@RequestBody Review reviews) {
//		LOG.info("Add Movie Review...");
//		//moviesService.addReview(reviews);
//
//		return moviesService.getMovieInfo(reviews.getMovieId());
//	}
}
