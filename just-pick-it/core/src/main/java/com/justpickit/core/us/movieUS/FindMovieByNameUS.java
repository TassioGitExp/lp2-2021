package com.justpickit.core.us.movieUS;

import com.justpickit.core.domain.Movie;
import com.justpickit.core.ports.driven_R.repository.MovieRepositoryPort;
import com.justpickit.core.ports.driver_L.moviePorts.FindMovieByNamePort;
import org.springframework.stereotype.Service;

@Service
public record FindMovieByNameUS(MovieRepositoryPort movieRepositoryPort) implements FindMovieByNamePort {

    @Override
    public Movie apply (String name){
        return movieRepositoryPort.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found!"));
    }
}
