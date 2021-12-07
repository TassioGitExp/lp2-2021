package com.justpickit.core.ports.driver_L.moviePorts;

import com.justpickit.core.domain.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface FindAllMoviesPort {

    Page<Movie> apply (Pageable pageable);

}
