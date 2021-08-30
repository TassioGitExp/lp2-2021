package br.edu.aluno.ifce.lp2.model.repositories;

import br.edu.aluno.ifce.lp2.model.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String>{

    boolean existsByName(String name);

}

