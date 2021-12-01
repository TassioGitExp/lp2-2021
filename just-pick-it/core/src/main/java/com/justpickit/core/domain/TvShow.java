package com.justpickit.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TvShow {

    private String id;
    private String name;
    private String genre;
    private String releaseDate;
    private int numberOfEpisodes;
    private int numberOfSeasons;
    private String durationPerEpisode;
    private String synopsis;

}
