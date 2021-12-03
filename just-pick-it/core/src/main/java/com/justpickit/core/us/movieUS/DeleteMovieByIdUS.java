package com.justpickit.core.us.movieUS;

import com.justpickit.core.ports.driven_R.repository.MovieRepositoryPort;
import com.justpickit.core.ports.driver_L.moviePorts.DeleteMovieByIdPort;
import org.springframework.stereotype.Service;

@Service
public record DeleteMovieByIdUS(MovieRepositoryPort movieRepositoryPort) implements DeleteMovieByIdPort {

    @Override
    public void apply (String id){
        movieRepositoryPort.deleteById(id);
    }
}
