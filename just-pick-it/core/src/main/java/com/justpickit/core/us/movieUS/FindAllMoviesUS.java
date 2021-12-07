package com.justpickit.core.us.movieUS;

import com.justpickit.core.domain.Movie;
import com.justpickit.core.ports.driven_R.repository.MovieRepositoryPort;
import com.justpickit.core.ports.driver_L.moviePorts.FindAllMoviesPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public record FindAllMoviesUS(MovieRepositoryPort movieRepositoryPort) implements FindAllMoviesPort {
    
    @Override
    public Page<Movie> apply(Pageable pageable){

        return movieRepositoryPort.findAll(pageable);
    }
    
}
