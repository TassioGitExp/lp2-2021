package com.justpickit.core.us.tvShowUS;

import com.justpickit.core.ports.driven_R.repository.TvShowRepositoryPort;
import com.justpickit.core.ports.driver_L.tvShowPorts.DeleteTvShowByIdPort;
import org.springframework.stereotype.Service;

@Service
public record DeleteTvShowByIdUS(TvShowRepositoryPort tvShowRepositoryPort) implements DeleteTvShowByIdPort {

    @Override
    public void apply (String id) {
        tvShowRepositoryPort.deleteById(id);
    }

}
