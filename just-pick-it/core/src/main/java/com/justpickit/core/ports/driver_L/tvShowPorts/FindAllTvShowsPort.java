package com.justpickit.core.ports.driver_L.tvShowPorts;

import com.justpickit.core.domain.TvShow;

import java.util.Collection;

public interface FindAllTvShowsPort {

    Collection<TvShow> apply ();

}
