package com.justpickit.core.ports.driver_L.moviePorts;

import com.justpickit.core.domain.Movie;

import java.util.Collection;

public interface FindMoviesByGenrePort {

    Collection<Movie> apply (String genre);

}
