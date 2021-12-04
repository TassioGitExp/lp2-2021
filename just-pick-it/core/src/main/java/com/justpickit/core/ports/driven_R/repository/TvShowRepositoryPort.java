package com.justpickit.core.ports.driven_R.repository;
import com.justpickit.core.domain.TvShow;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public interface TvShowRepositoryPort {

    public TvShow save (TvShow tvShow);

    public boolean existsById (String id);

    public boolean existsByName (String name);

    public Optional<TvShow> findByName (String name);

    public Optional<TvShow> findById (String id);

    public Collection<TvShow> findByGenre (String genre);

    public Collection<TvShow> findAll ();

    void deleteById (String id);

}
