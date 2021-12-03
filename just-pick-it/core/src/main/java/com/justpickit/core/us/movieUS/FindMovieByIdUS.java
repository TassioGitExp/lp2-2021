package com.justpickit.core.us.movieUS;

import com.justpickit.core.domain.Movie;
import com.justpickit.core.ports.driven_R.repository.MovieRepositoryPort;
import com.justpickit.core.ports.driver_L.moviePorts.FindMovieByIdPort;
import org.springframework.stereotype.Service;

@Service
public record FindMovieByIdUS(MovieRepositoryPort movieRepositoryPort) implements FindMovieByIdPort {

    @Override
    public Movie apply(String id) {

        return movieRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found!"));

    }
}
