package com.justpickit.core.ports.driven_R.repository;
import com.justpickit.core.domain.Movie;

import java.util.Optional;

public interface MovieRepositoryPort {

    public Movie save (Movie movie);

    public boolean existsById (String id);

    public boolean existsByName (String name);

    public Optional<Movie> findByName (String name);

    public Optional<Movie> findById (String id);

    public Optional<Movie> findByGenre (String genre);

    void deleteById (String id);

}
