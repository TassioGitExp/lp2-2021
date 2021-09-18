package br.edu.aluno.ifce.lp2.model.services;

import br.edu.aluno.ifce.lp2.model.entities.Client;
import br.edu.aluno.ifce.lp2.model.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client create(Client client) { //Mudar para email!
        if(clientRepository.existsByEmail(client.getEmail())) {
            throw new RuntimeException("Cliente já existe!");
        }

        return clientRepository.save(client);
    }

    public Client update(String id, Client client) {
        //Não pode haver objs com o mesmo email, outros atributos podem ser repetidos.

        var clientDatabase = this.getById(id); //Salva client antigo

        //Procura um objeto no banco com o email inserido(body).
        var c = clientRepository.findByEmail(client.getEmail());
        //Se "c" for nulo, o email não está sendo usado; (OK)
        //Se não for nulo e tiver id igual,
        //está modificando o obj correspondente ao email, exceto o seu email; (OK)
        //Se não for nulo e o id for diferente, está modificando o email de um obj,
        //porem esse email já está sendo usado por outro obj. (NOT ok)

        //Verifica se o objeto com o mesmo email existe (!null), &&
        //Verifica se o id do objeto é igual ao inserido.
        //Se o objeto existe e tem o id diferente do inserido, throw exeption.
        //(Está tentando usar o email de um objeto já existente no banco de dados.)
        if(c != null && !c.getId().equals(id)) {
            throw new RuntimeException("Email já existe"); // Arrumar isso aqui.
                                                          // Preciso entender melhor.
                                                         // Acho que entendi.
        }

        //Substitui os dados do client antigo.
        clientDatabase.setName(client.getName());
        clientDatabase.setEmail(client.getEmail());
        clientDatabase.setPassword(client.getPassword());
        clientDatabase.setEnabled(client.isEnabled());

        return clientRepository.save(clientDatabase);
    }

    public Page<Client> getAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    public Client getById(String id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client não existe!"));
    }

    public void delete(String id) {
        clientRepository.deleteById(id);
    }
}
