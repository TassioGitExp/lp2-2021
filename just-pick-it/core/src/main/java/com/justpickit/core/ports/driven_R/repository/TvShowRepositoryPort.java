package com.justpickit.core.ports.driven_R.repository;
import com.justpickit.core.domain.TvShow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;

public interface TvShowRepositoryPort {

    TvShow save(TvShow tvShow);

    boolean existsById(String id);

    boolean existsByName(String name);

    Optional<TvShow> findByName(String name);

    Optional<TvShow> findById(String id);

    Collection<TvShow> findByGenre(String genre);

    Page<TvShow> findAll(Pageable pageable);

    void deleteById (String id);

}
