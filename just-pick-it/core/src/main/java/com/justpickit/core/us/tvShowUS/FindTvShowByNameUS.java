package com.justpickit.core.us.tvShowUS;

import com.justpickit.core.domain.TvShow;
import com.justpickit.core.ports.driven_R.repository.TvShowRepositoryPort;
import com.justpickit.core.ports.driver_L.tvShowPorts.FindTvShowByNamePort;
import org.springframework.stereotype.Service;

@Service
public record FindTvShowByNameUS(TvShowRepositoryPort tvShowRepositoryPort) implements FindTvShowByNamePort {

    @Override
    public TvShow apply (String name) {
        return tvShowRepositoryPort.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Tv Show not found!"));
    }
}
