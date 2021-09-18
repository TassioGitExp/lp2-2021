package br.edu.aluno.ifce.lp2.controller.request;

import br.edu.aluno.ifce.lp2.model.entities.Client;
import lombok.Setter;

@Setter
public class ClientRequest {
    private String name;
    private String email;
    private String password;
    private boolean enabled;

    public Client toClient() {
        var client = new Client();

        client.setName(name);
        client.setEmail(email);
        client.setPassword(password);
        client.setEnabled(enabled);

        return client;
    }
}
