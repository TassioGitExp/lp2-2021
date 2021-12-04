package com.justpickit.core.ports.driver_L.tvShowPorts;

import com.justpickit.core.domain.TvShow;

import java.util.Collection;

public interface FindTvShowsByGenrePort {

    Collection<TvShow> apply (String genre);

}
