package br.edu.aluno.ifce.lp2.controller;

import br.edu.aluno.ifce.lp2.controller.request.ClientRequest;
import br.edu.aluno.ifce.lp2.controller.response.ClientResponse;
import br.edu.aluno.ifce.lp2.model.services.ClientService;
import br.edu.aluno.ifce.lp2.model.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ClientResponse post(@RequestBody ClientRequest clientRequest) {
        var client = clientRequest.toClient();

        return new ClientResponse().fromClient(clientService.create(client));
    }

    @GetMapping
    public Page<ClientResponse> get(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int linesPerPage,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(defaultValue = "name") String orderBy
    ) {
        var pageable = PageRequest
                .of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        return clientService.getAll(pageable)
                .map(c -> new ClientResponse().fromClient(c));
    }

    @GetMapping("{id}")
    public Client getById(@PathVariable String id) {
        return clientService.getById(id);
    }

    @PutMapping("{id}")
    public ClientResponse put(@PathVariable String id, @RequestBody ClientRequest clientRequest) {
        var client = clientRequest.toClient();

        return new ClientResponse().fromClient(clientService.update(id, client));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        clientService.delete(id);
    }
}
