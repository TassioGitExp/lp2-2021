package com.justpickit.controller;

import com.justpickit.controller.request.MovieRequest;
import com.justpickit.controller.response.MovieResponse;
import com.justpickit.core.ports.driver_L.moviePorts.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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

    @GetMapping("name/{name}")
    public MovieResponse getName (@PathVariable String name) {
        var movie = findMovieByNamePort.apply(name);

        return new MovieResponse().fromMovie(movie);
    }

    //Acho que parte de gerar um filme aleatorio
    //seria aqui, com o get mapping("{gender}/{filme}")
    //mais ou menos isso, retornando um elemento aleatório
    //de uma lista. Acho que assim é possivel.

    //1 - findByGenre retorna uma Lista com todos elementos com o genero escolhido
    //2 - achar um elemento aleatorio nessa lista

    //Teste get all - OK
    @GetMapping("list/all")
    public Collection<MovieResponse> getAll (){
      return findAllMoviesPort.apply().stream()
              .map(p -> new MovieResponse().fromMovie(p))
              .collect(Collectors.toList());
    }

    //Teste get random by genre -OK
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
