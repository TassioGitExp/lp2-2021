package com.justpickit.controller;

import com.justpickit.controller.request.TvShowRequest;
import com.justpickit.controller.response.TvShowResponse;
import com.justpickit.core.ports.driver_L.tvShowPorts.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tv-shows")
public record TvShowController(
        AddTvShowPort addTvShowPort,
        FindTvShowByIdPort findTvShowByIdPort,
        FindTvShowByNamePort findTvShowByNamePort,
        DeleteTvShowByIdPort deleteTvShowByIdPort,
        FindAllTvShowsPort findAllTvShowsPort,
        FindTvShowsByGenrePort findTvShowsByGenrePort
) {

    @PostMapping
    public TvShowResponse post(@RequestBody TvShowRequest tvShowRequest) {
        var tvShow = tvShowRequest.toTvShow();
        tvShow = addTvShowPort.apply(tvShow);
        return new TvShowResponse().fromTvshow(tvShow);
    }

    @GetMapping("id/{id}")
    public TvShowResponse get(@PathVariable String id) {
        var tvShow = findTvShowByIdPort.apply(id);

        return new TvShowResponse().fromTvshow(tvShow);
    }

    @GetMapping("name/{name}")
    public TvShowResponse getName(@PathVariable String name) {
        var tvShow = findTvShowByNamePort.apply(name);

        return new TvShowResponse().fromTvshow(tvShow);
    }

    @GetMapping("list/all")
    public Collection<TvShowResponse> getAll () {
        return findAllTvShowsPort.apply().stream()
                .map(p -> new TvShowResponse().fromTvshow(p))
                .collect(Collectors.toList());
    }

    @GetMapping("recommendation/{genre}")
    public TvShowResponse getByGenre (@PathVariable String genre) {
        var collection = findTvShowsByGenrePort.apply(genre).stream()
                .map(p -> new TvShowResponse().fromTvshow(p))
                .collect(Collectors.toList());
        var rand = new Random();

        return collection.get(rand.nextInt(collection.size()));
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id) {
        deleteTvShowByIdPort.apply(id);
    }
}
