package com.justpickit.controller;

import com.justpickit.controller.request.TvShowRequest;
import com.justpickit.controller.response.TvShowResponse;
import com.justpickit.core.domain.TvShow;
import com.justpickit.core.ports.driver_L.tvShowPorts.AddTvShowPort;
import com.justpickit.core.ports.driver_L.tvShowPorts.DeleteTvShowByIdPort;
import com.justpickit.core.ports.driver_L.tvShowPorts.FindTvShowByIdPort;
import com.justpickit.core.ports.driver_L.tvShowPorts.FindTvShowByNamePort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tv-shows")
public record TvShowController(
        AddTvShowPort addTvShowPort,
        FindTvShowByIdPort findTvShowByIdPort,
        FindTvShowByNamePort findTvShowByNamePort,
        DeleteTvShowByIdPort deleteTvShowByIdPort
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

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id) {
        deleteTvShowByIdPort.apply(id);
    }
}
