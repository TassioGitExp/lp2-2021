package com.justpickit.core.ports.driver_L.moviePorts;

import com.justpickit.core.domain.Movie;

public interface AddMoviePort {

    Movie apply (Movie movie);

}
