package com.justpickit.controller.request;

import com.justpickit.core.domain.TvShow;
import lombok.Setter;

@Setter
public class TvShowRequest {

    private String name;
    private String genre;
    private String releaseDate;
    private int numberOfEpisodes;
    private int numberOfSeasons;
    private String durationPerEpisode;
    private String director;
    private String synopsis;

    public TvShow toTvShow() {
        var tvShow = new TvShow();

        tvShow.setName(name);
        tvShow.setGenre(genre);
        tvShow.setReleaseDate(releaseDate);
        tvShow.setNumberOfEpisodes(numberOfEpisodes);
        tvShow.setNumberOfSeasons(numberOfSeasons);
        tvShow.setDurationPerEpisode(durationPerEpisode);
        tvShow.setDirector(director);
        tvShow.setSynopsis(synopsis);

        return tvShow;
    }

}
