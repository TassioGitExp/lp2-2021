package com.justpickit.core.ports.driver_L.moviePorts;

import com.justpickit.core.domain.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface FindAllMoviesPort {

    Page<Movie> apply (Pageable pageable);

}
