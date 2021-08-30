package br.edu.aluno.ifce.lp2.model.services;

import br.edu.aluno.ifce.lp2.model.entities.Client;
import br.edu.aluno.ifce.lp2.model.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void create(Client client) {
        if(!clientRepository.existsByName(client.getName())) {
            clientRepository.save(client);
        }
    }

    public void update(String id, Client client) {
        var canUpdate = this.getById(id) != null;

        if(canUpdate) {
            clientRepository.save(client);
        }
    }

    public Collection<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getById(String id) {
        return clientRepository.findById(id).orElse(new Client());
    }

    public void delete(String id) {
        clientRepository.deleteById(id);
    }
}
