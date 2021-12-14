package com.justpickit.core.us.movieUS;

import com.justpickit.core.domain.Movie;
import com.justpickit.core.ports.driven_R.repository.MovieRepositoryPort;
import com.justpickit.core.ports.driver_L.moviePorts.AddMoviePort;
import org.springframework.stereotype.Service;

@Service
public record AddMovieUS(MovieRepositoryPort movieRepositoryPort) implements AddMoviePort {

    @Override
    public Movie apply (Movie movie) {

        if(movieRepositoryPort.existsByName(movie.getName()))
            throw new IllegalStateException("This name is already being used!");

        movieRepositoryPort.save(movie);

        return movie;
    }

}
