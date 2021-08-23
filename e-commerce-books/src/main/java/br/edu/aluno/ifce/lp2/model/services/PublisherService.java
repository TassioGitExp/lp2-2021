package br.edu.aluno.ifce.lp2.model.services;

import br.edu.aluno.ifce.lp2.model.repositories.PublisherRepository;
import br.edu.aluno.ifce.lp2.model.entities.Publisher;

import java.util.Collection;

public class PublisherService {
    private static PublisherRepository publisherRepository = new PublisherRepository();

    private boolean doExists(Publisher publisher) {
        return publisherRepository
                .getAll()
                .stream()
                .anyMatch(p -> p.getNome().toLowerCase().trim().equals(publisher.getNome().toLowerCase().trim()));
    }

    public void create(Publisher publisher) {
        if(!doExists(publisher)) {
            publisherRepository.create(publisher);
        }
    }

    public void update(Long id, Publisher publisher) {
        var canUpdate = this.getById(id) != null;

        if(canUpdate) {
            if(!doExists(publisher)) {
                publisherRepository.update(id, publisher);
            }
        }
    }

    public Collection<Publisher> getAll(){
        return publisherRepository.getAll();
    }

    public Publisher getById(Long id) {
        return publisherRepository.getById(id);
    }

    public void delete(Long id) {
        publisherRepository.delete(id);
    }
}
