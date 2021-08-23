package br.edu.aluno.ifce.lp2.controller;

import br.edu.aluno.ifce.lp2.model.services.PublisherService;
import br.edu.aluno.ifce.lp2.model.entities.Publisher;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("publishers")
public class PublisherController {
    private static PublisherService publisherService = new PublisherService();

    @PostMapping
    public void post(@RequestBody Publisher publisher) {
        publisherService.create(publisher);
    }

    @GetMapping
    public Collection<Publisher> get() {
        return publisherService.getAll();
    }

    @GetMapping("{id}")
    public Publisher getById(@PathVariable Long id) {
        return publisherService.getById(id);
    }

    @PutMapping("{id}")
    public void put(@PathVariable Long id, @RequestBody Publisher publisher) {
        publisher.setId(id);
        publisherService.update(id, publisher);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        publisherService.delete(id);
    }
}
