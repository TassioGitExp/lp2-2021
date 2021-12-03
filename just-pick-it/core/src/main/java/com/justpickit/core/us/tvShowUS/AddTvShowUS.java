package com.justpickit.core.us.tvShowUS;

import com.justpickit.core.domain.TvShow;
import com.justpickit.core.ports.driven_R.repository.TvShowRepositoryPort;
import com.justpickit.core.ports.driver_L.tvShowPorts.AddTvShowPort;
import org.springframework.stereotype.Service;

@Service
public record AddTvShowUS(TvShowRepositoryPort tvShowRepositoryPort) implements AddTvShowPort {

    @Override
    public TvShow apply (TvShow tvShow) {

        //Nome precisa ser unico
        if(tvShowRepositoryPort.existsByName(tvShow.getName()))
            throw new IllegalStateException("This name is already being used!");

        tvShowRepositoryPort.save(tvShow);

        return tvShow;
    }
}
