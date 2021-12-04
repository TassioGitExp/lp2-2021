package com.justpickit.core.us.tvShowUS;

import com.justpickit.core.domain.TvShow;
import com.justpickit.core.ports.driven_R.repository.TvShowRepositoryPort;
import com.justpickit.core.ports.driver_L.tvShowPorts.FindAllTvShowsPort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public record FindAllTvShowsUS(TvShowRepositoryPort tvShowRepositoryPort) implements FindAllTvShowsPort {

    @Override
    public Collection<TvShow> apply() {
        return tvShowRepositoryPort.findAll();
    }

}
