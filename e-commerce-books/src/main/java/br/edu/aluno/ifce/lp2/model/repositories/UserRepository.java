package br.edu.aluno.ifce.lp2.model.repositories;

import br.edu.aluno.ifce.lp2.model.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

    boolean existsByName(String name);

}
