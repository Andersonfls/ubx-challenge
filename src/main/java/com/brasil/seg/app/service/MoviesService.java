package com.brasil.seg.app.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.brasil.seg.app.model.Genre;
import com.brasil.seg.app.model.Language;
import com.brasil.seg.app.model.Movie;
import com.brasil.seg.app.repository.GenreRepository;
import com.brasil.seg.app.repository.LanguageRepository;
import com.brasil.seg.app.repository.MoviesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviesService {

	private static final Logger LOG = LoggerFactory.getLogger(MoviesService.class);

	@Autowired
	private LanguageRepository languageRepository;

	@Autowired
	private GenreRepository genreRepository;

	@Autowired
	private MoviesRepository moviesRepository;

	public List<Language> getAllLanguages() {
		return (List<Language>) languageRepository.findAll();
	}

	public List<Genre> getAllGenres() {
		return (List<Genre>) genreRepository.findAll();
	}

	public List<Movie> getAllMovies() {
		List<Movie> list = (List<Movie>) moviesRepository.findAll();
		updateLanguageGenres(list);
		return list;
	}

	public void addMovie(Movie movie) {
		movie.setCreatedTimestamp(new Date());
		movie.setLastUpdtTimestamp(new Date());
		moviesRepository.save(movie);
	}

	public Movie getMovieInfo(Long movieId) {
		Optional<Movie> movieOptional = moviesRepository.findById(movieId);
		Movie movie = movieOptional.get();
		return movie;
	}

	/**
	 * Delete the movie by id.
	 *
	 * @param id the id of the entity
	 */
	public void deleteById(Long id) {
		moviesRepository.deleteById(id);
	}

	private void updateLanguageGenres(List<Movie> list) {
		Map<Integer, String> languageMap = new HashMap<>();
		Map<Integer, String> genreMap = new HashMap<>();

		List<Language> languageList = getAllLanguages();
		languageList.parallelStream().forEach(obj -> languageMap.put(obj.getId(), obj.getName()));

		List<Genre> genreList = getAllGenres();
		genreList.parallelStream().forEach(obj -> genreMap.put(obj.getId(), obj.getName()));

		list.parallelStream().forEach(obj -> {
			obj.setLanguage(languageMap.get(obj.getLanguageId()));
			obj.setGenre(genreMap.get(obj.getGenreId()));
		});

	}

}
