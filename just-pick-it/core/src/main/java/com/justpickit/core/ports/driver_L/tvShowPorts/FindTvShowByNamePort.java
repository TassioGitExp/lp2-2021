package com.justpickit.core.ports.driver_L.tvShowPorts;

import com.justpickit.core.domain.TvShow;

public interface FindTvShowByNamePort {

    TvShow apply (String name);

}
