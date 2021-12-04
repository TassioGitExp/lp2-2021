package com.justpickit.core.ports.driver_L.moviePorts;

import com.justpickit.core.domain.Movie;

import java.util.Collection;
import java.util.List;

public interface FindAllMoviesPort {

    Collection<Movie> apply ();

}
