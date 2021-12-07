package com.justpickit.core.ports.driven_R.repository;
import com.justpickit.core.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    Page<Movie> findAll(Pageable pageable);

    void deleteById (String id);

}
