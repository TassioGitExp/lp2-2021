package com.justpickit.core.ports.driven_R.repository;
import com.justpickit.core.domain.TvShow;

import java.util.Optional;

public interface TvShowRepositoryPort {

    public TvShow save (TvShow tvShow);

    public boolean existsById (String id);

    public boolean existsByName (String name);

    public Optional<TvShow> findByName (String name);

    public Optional<TvShow> findById (String id);

    public Optional<TvShow> findByGenre (String genre);

    void deleteById (String id);

}
