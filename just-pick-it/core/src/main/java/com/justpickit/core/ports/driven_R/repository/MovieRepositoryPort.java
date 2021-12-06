package com.justpickit.core.ports.driven_R.repository;
import com.justpickit.core.domain.Movie;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MovieRepositoryPort {

    Movie save(Movie movie);

    boolean existsById(String id);

    boolean existsByName(String name);

    Optional<Movie> findByName(String name);

    Optional<Movie> findById(String id);

    Collection<Movie> findByGenre(String genre);

    Collection<Movie> findAll();

    void deleteById (String id);

}
