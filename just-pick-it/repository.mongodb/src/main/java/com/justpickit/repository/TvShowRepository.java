package com.justpickit.repository;

import com.justpickit.core.domain.TvShow;
import com.justpickit.core.ports.driven_R.repository.TvShowRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TvShowRepository extends MongoRepository<TvShow, String>, TvShowRepositoryPort {
}
