package com.justpickit.core.us.tvShowUS;

import com.justpickit.core.domain.TvShow;
import com.justpickit.core.ports.driven_R.repository.TvShowRepositoryPort;
import com.justpickit.core.ports.driver_L.tvShowPorts.FindTvShowsByGenrePort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public record FIndTvShowsByGenreUS(TvShowRepositoryPort tvShowRepositoryPort) implements FindTvShowsByGenrePort {

    @Override
    public Collection<TvShow> apply(String genre) {
        if(tvShowRepositoryPort.findByGenre(genre).isEmpty())
            throw new IllegalStateException("Genre not found!");

        return tvShowRepositoryPort.findByGenre(genre);
    }

}
