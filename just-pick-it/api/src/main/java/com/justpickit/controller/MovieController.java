package com.justpickit.controller;

import com.justpickit.controller.request.MovieRequest;
import com.justpickit.controller.response.MovieResponse;
import com.justpickit.core.ports.driver_L.moviePorts.AddMoviePort;
import com.justpickit.core.ports.driver_L.moviePorts.DeleteMovieByIdPort;
import com.justpickit.core.ports.driver_L.moviePorts.FindMovieByIdPort;
import com.justpickit.core.ports.driver_L.moviePorts.FindMovieByNamePort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public record MovieController(
        AddMoviePort addMoviePort,
        FindMovieByIdPort findMovieByIdPort,
        FindMovieByNamePort findMovieByNamePort,
        DeleteMovieByIdPort deleteMovieByIdPort
) {

    @PostMapping
    public MovieResponse post (@RequestBody MovieRequest movieRequest) {
        var movie = movieRequest.toMovie();
        movie = addMoviePort.apply(movie);
        return new MovieResponse().fromMovie(movie);
    }

    @GetMapping("id/{id}")
    public MovieResponse get (@PathVariable String id) {
        var movie = findMovieByIdPort.apply(id);

        return new MovieResponse().fromMovie(movie);
    }

    @GetMapping("name/{name}")
    public MovieResponse getName (@PathVariable String name) {
        var movie = findMovieByNamePort.apply(name);

        return new MovieResponse().fromMovie(movie);
    }

    @DeleteMapping("delete/{id}")
    public void delete (@PathVariable String id) {
        deleteMovieByIdPort.apply(id);
    }
}
