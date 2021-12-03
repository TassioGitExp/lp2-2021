package com.justpickit.core.us.tvShowUS;

import com.justpickit.core.domain.TvShow;
import com.justpickit.core.ports.driven_R.repository.TvShowRepositoryPort;
import com.justpickit.core.ports.driver_L.tvShowPorts.FindTvShowByIdPort;
import org.springframework.stereotype.Service;

@Service
public record FindTvShowByIdUS(TvShowRepositoryPort tvShowRepositoryPort) implements FindTvShowByIdPort {

    @Override
    public TvShow apply (String id) {
        return tvShowRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tv show not found!"));
    }
}
