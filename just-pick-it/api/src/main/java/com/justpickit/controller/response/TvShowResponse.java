package com.justpickit.controller.response;

import com.justpickit.core.domain.TvShow;
import lombok.Getter;

@Getter
public class TvShowResponse {

    private String id;
    private String name;
    private String genre;
    private String releaseDate;
    private int numberOfEpisodes;
    private int numberOfSeasons;
    private String durationPerEpisode;
    private String creator;
    private String synopsis;

    public TvShowResponse fromTvshow(TvShow tvShow) {

        this.id = tvShow.getId();
        this.name = tvShow.getName();
        this.genre = tvShow.getGenre();
        this.releaseDate = tvShow.getReleaseDate();
        this.numberOfEpisodes = tvShow.getNumberOfEpisodes();
        this.numberOfSeasons = tvShow.getNumberOfSeasons();
        this.durationPerEpisode = tvShow.getDurationPerEpisode();
        this.creator = tvShow.getCreator();
        this.synopsis = tvShow.getSynopsis();

        return  this;
    }

}
