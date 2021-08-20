package br.edu.aluno.ifce.lp2.controller;

import br.edu.aluno.ifce.lp2.model.entities.Publisher;
import br.edu.aluno.ifce.lp2.model.repositories.PublisherRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("publishers")
public class PublisherController {
    private static PublisherRepository publisherRepository = new PublisherRepository();

    @PostMapping
    public void post(@RequestBody Publisher publisher) {
        publisherRepository.create(publisher);
    }

    @GetMapping
    public Collection<Publisher> get() {
        return publisherRepository.getAll();
    }

    @PutMapping({"id"})
    public void put(@PathVariable Long id, @RequestBody Publisher publisher) {
        publisher.setId(id);
        publisherRepository.update(id, publisher);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable Long id) {
        publisherRepository.delete(id);
    }
}
