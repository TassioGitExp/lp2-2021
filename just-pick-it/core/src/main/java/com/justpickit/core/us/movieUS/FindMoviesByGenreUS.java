package com.justpickit.core.us.movieUS;

import com.justpickit.core.domain.Movie;
import com.justpickit.core.ports.driven_R.repository.MovieRepositoryPort;
import com.justpickit.core.ports.driver_L.moviePorts.FindMoviesByGenrePort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public record FindMoviesByGenreUS(MovieRepositoryPort movieRepositoryPort) implements FindMoviesByGenrePort {

    @Override
    public Collection<Movie> apply (String genre){
        if(movieRepositoryPort.findByGenre(genre).isEmpty())
            throw new IllegalStateException("Genre not found!");

        return movieRepositoryPort.findByGenre(genre);
    }

}
