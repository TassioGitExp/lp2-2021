package br.edu.aluno.ifce.lp2.model.services;

import br.edu.aluno.ifce.lp2.model.entities.Publisher;
import br.edu.aluno.ifce.lp2.model.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public void create(Publisher publisher) {
        if(!publisherRepository.existsByName(publisher.getName())) {
            publisherRepository.save(publisher);
        }
    }

    public void update(String id, Publisher publisher) {
        var canUpdate = this.getById(id) != null;

        if(canUpdate) {
            publisherRepository.save(publisher);
        }
    }

    public Collection<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    public Publisher getById(String id) {
        return publisherRepository.findById(id).orElse(new Publisher());
    }

    public void delete(String id) {
        publisherRepository.deleteById(id);
    }

}
