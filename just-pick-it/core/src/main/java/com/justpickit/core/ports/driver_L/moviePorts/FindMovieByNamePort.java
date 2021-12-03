package com.justpickit.core.ports.driver_L.moviePorts;

import com.justpickit.core.domain.Movie;

public interface FindMovieByNamePort {

    Movie apply (String name);

}
