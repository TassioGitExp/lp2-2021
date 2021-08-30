package br.edu.aluno.ifce.lp2.controller;

import br.edu.aluno.ifce.lp2.model.entities.Publisher;
import br.edu.aluno.ifce.lp2.model.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import br.edu.aluno.ifce.lp2.model.repositories.ClientRepository;
import br.edu.aluno.ifce.lp2.model.entities.Client;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public void post(@RequestBody Client client) {
        clientService.create(client);
    }

    @GetMapping
    public Collection<Client> get() {
        return clientService.getAll();
    }

    @GetMapping("{id}")
    public Client getById(@PathVariable String id) {
        return clientService.getById(id);
    }

    @PutMapping("{id}")
    public void put(@PathVariable String id, @RequestBody Client client) {
        client.setId(id);
        clientService.update(id, client);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        clientService.delete(id);
    }
}
