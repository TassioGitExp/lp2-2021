package br.edu.aluno.ifce.lp2.controller;

import br.edu.aluno.ifce.lp2.model.entities.Client;
import br.edu.aluno.ifce.lp2.model.repositories.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("clients")
public class ClientController {
    private static ClientRepository clientRepository = new ClientRepository();

    @PostMapping
    public void post(@RequestBody Client client) {
        clientRepository.create(client);
    }

    @GetMapping
    public Collection<Client> get() {
        return clientRepository.getAll();
    }

    @PutMapping({"id"})
    public void put(@PathVariable Long id, @RequestBody Client client) {
        client.setId(id);
        clientRepository.update(id, client);
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable Long id) {
        clientRepository.delete(id);
    }
}
