package br.edu.aluno.ifce.lp2.model.repositories;

import br.edu.aluno.ifce.lp2.model.entities.Client;

import java.util.Collection;
import  java.util.HashMap;
import java.util.Map;

public class ClientRepository {
    public static Long ids = 1L;
    public static Map<Long, Client> data;

    public ClientRepository() {
        data = new HashMap<>();
    }

    public void create(Client client) {
        client.setId(ids);
        data.put(ids, client);
        ids++;
    }

    public void update(Long id, Client client) {
        data.put(id, client);
    }

    public void delete(Long id) {
        data.remove(id);
    }

    public Collection<Client> getAll() {
        return data.values();
    }
}
