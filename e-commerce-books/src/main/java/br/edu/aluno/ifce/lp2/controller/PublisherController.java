package br.edu.aluno.ifce.lp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import br.edu.aluno.ifce.lp2.model.services.PublisherService;
import br.edu.aluno.ifce.lp2.model.entities.Publisher;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping
    public void post(@RequestBody Publisher publisher) {
        publisherService.create(publisher);
    }

    @GetMapping
    public Collection<Publisher> get() {
        return publisherService.getAll();
    }

    @GetMapping("{id}")
    public Publisher getById(@PathVariable String id) {
        return publisherService.getById(id);
    }

    @PutMapping("{id}")
    public void put(@PathVariable String id, @RequestBody Publisher publisher) {
        publisher.setId(id);
        publisherService.update(id, publisher);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        publisherService.delete(id);
    }
}
