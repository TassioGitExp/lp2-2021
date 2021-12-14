package com.justpickit.controller;

import com.justpickit.controller.request.MovieRequest;
import com.justpickit.controller.response.MovieResponse;
import com.justpickit.core.ports.driver_L.moviePorts.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("movies")
public record MovieController(
        AddMoviePort addMoviePort,
        FindMovieByIdPort findMovieByIdPort,
        FindMovieByNamePort findMovieByNamePort,
        DeleteMovieByIdPort deleteMovieByIdPort,
        FindAllMoviesPort findAllMoviesPort,
        FindMoviesByGenrePort findMoviesByGenrePort
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

    @GetMapping("search")
    public MovieResponse getName (@RequestParam String name) {
        var movie = findMovieByNamePort.apply(name);

        return new MovieResponse().fromMovie(movie);
    }

    @GetMapping("list/all")
    public Page<MovieResponse> getAll (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int itemsPerPage,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(defaultValue = "name") String orderBy
    ){
        var pageable = PageRequest
                .of(page, itemsPerPage, Sort.Direction.fromString(direction), orderBy);

      return findAllMoviesPort.apply(pageable)
              .map(p -> new MovieResponse().fromMovie(p));
    }

    @GetMapping("recommendation/{genre}")
    public MovieResponse getByGenre (@PathVariable String genre) {

        var collection = findMoviesByGenrePort.apply(genre).stream()
                .map(p -> new MovieResponse().fromMovie(p))
                .collect(Collectors.toList());

        var rand = new Random();

        return collection.get(rand.nextInt(collection.size()));
    }

    @DeleteMapping("delete/{id}")
    public void delete (@PathVariable String id) {
        deleteMovieByIdPort.apply(id);
    }
}
