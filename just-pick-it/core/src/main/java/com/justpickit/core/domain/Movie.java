package com.justpickit.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {

    private String id;
    private String name;
    private String genre;
    private String releaseDate;
    private String duration;
    private String synopsis;

}
