package com.justpickit.core.ports.driver_L.tvShowPorts;

import com.justpickit.core.domain.TvShow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindAllTvShowsPort {

    Page<TvShow> apply (Pageable pageable);

}
