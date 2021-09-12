package br.edu.aluno.ifce.lp2.model.services;

import br.edu.aluno.ifce.lp2.model.entities.Publisher;
import br.edu.aluno.ifce.lp2.model.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher create(Publisher publisher) {
        if(publisherRepository.existsByName(publisher.getName())) {
            throw new RuntimeException("Nome já existe!");
        }

        return publisherRepository.save(publisher);
    }

    public Publisher update(String id, Publisher publisher) {
        var publisherDatabase = this.getById(id);

        var p = publisherRepository.findByName(publisher.getName());

        if(p != null &&p.getId().equals(id)){
            throw new RuntimeException("Nome já existe!");
        }

        publisherDatabase.setName(publisher.getName());
        publisherDatabase.setTelephone(publisher.getTelephone());

        return publisherRepository.save(publisherDatabase);
    }

    public Page<Publisher> getAll(Pageable pageable) {
        return publisherRepository.findAll(pageable);
    }

    public Publisher getById(String id) {
        return publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher não existe!"));
    }

    public void delete(String id) {
        publisherRepository.deleteById(id);
    }

}
