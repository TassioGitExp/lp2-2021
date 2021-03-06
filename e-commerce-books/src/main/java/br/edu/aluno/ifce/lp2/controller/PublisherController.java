package br.edu.aluno.ifce.lp2.controller;

import br.edu.aluno.ifce.lp2.controller.request.PublisherRequest;
import br.edu.aluno.ifce.lp2.controller.response.PublisherResponse;
import br.edu.aluno.ifce.lp2.model.services.PublisherService;
import br.edu.aluno.ifce.lp2.model.entities.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping
    public PublisherResponse post(@RequestBody PublisherRequest request) {
        var publisher = request.toPublisher();
        return new PublisherResponse().fromPublisher(publisherService.create(publisher));
    }

    @GetMapping
    public Page<PublisherResponse> get(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "6") int linesPerPage,
        @RequestParam(defaultValue = "ASC") String direction,
        @RequestParam(defaultValue = "name") String orderBy
    ) {
        var pageable = PageRequest
                .of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        return publisherService.getAll(pageable)
                .map(p -> new PublisherResponse().fromPublisher(p));
    }

    @GetMapping("{id}")
    public Publisher getById(@PathVariable String id) {
        return publisherService.getById(id);
    }

    @PutMapping("{id}")
    public PublisherResponse put(@PathVariable String id, @RequestBody PublisherRequest request) {
        var publisher = request.toPublisher();

        return new PublisherResponse().fromPublisher(publisherService.update(id, publisher));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        publisherService.delete(id);
    }
}
