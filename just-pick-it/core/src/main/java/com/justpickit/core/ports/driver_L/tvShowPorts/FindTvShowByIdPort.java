package com.justpickit.core.ports.driver_L.tvShowPorts;

import com.justpickit.core.domain.TvShow;

public interface FindTvShowByIdPort {

    TvShow apply (String id);

}
