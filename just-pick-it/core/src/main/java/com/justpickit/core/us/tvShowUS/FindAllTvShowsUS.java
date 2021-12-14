package com.justpickit.core.us.tvShowUS;

import com.justpickit.core.domain.TvShow;
import com.justpickit.core.ports.driven_R.repository.TvShowRepositoryPort;
import com.justpickit.core.ports.driver_L.tvShowPorts.FindAllTvShowsPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public record FindAllTvShowsUS(TvShowRepositoryPort tvShowRepositoryPort) implements FindAllTvShowsPort {

    @Override
    public Page<TvShow> apply(Pageable pageable) {

        return tvShowRepositoryPort.findAll(pageable);
    }

}
