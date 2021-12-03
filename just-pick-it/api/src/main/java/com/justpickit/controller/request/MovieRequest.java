package com.justpickit.controller.request;

import com.justpickit.core.domain.Movie;
import lombok.Setter;

@Setter
public class MovieRequest {

    private String name;
    private String genre;
    private String releaseDate;
    private String duration;
    private String synopsis;

    public Movie toMovie() {
        var movie = new Movie();

        movie.setName(name);
        movie.setGenre(genre);
        movie.setReleaseDate(releaseDate);
        movie.setDuration(duration);
        movie.setSynopsis(synopsis);

        return movie;
    }
}
