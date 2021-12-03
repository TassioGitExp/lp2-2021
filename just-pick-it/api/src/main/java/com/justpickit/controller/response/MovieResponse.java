package com.justpickit.controller.response;

import com.justpickit.core.domain.Movie;
import lombok.Getter;

@Getter
public class MovieResponse {

    private String id;
    private String name;
    private String genre;
    private String releaseDate;
    private String duration;
    private String synopsis;

    public MovieResponse fromMovie(Movie movie) {

        this.id = movie.getId();
        this.name = movie.getName();
        this.genre = movie.getGenre();
        this.releaseDate = movie.getReleaseDate();
        this.duration = movie.getDuration();
        this.synopsis = movie.getSynopsis();

        return this;
    }

}
