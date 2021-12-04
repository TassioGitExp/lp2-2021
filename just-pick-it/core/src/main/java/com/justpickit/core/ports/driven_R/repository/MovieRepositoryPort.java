package com.justpickit.core.ports.driven_R.repository;
import com.justpickit.core.domain.Movie;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MovieRepositoryPort {

    public Movie save (Movie movie);

    public boolean existsById (String id);

    public boolean existsByName (String name);

    public Optional<Movie> findByName (String name);

    public Optional<Movie> findById (String id);

    public Collection<Movie> findByGenre (String genre);

    public Collection<Movie> findAll ();

    void deleteById (String id);

}
