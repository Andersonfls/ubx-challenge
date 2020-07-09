package com.brasil.seg.app.repository;

import com.brasil.seg.app.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MoviesRepository extends CrudRepository<Movie, Long> {

}
