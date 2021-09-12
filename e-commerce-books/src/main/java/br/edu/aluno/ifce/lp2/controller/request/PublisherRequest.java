package br.edu.aluno.ifce.lp2.controller.request;

import br.edu.aluno.ifce.lp2.model.entities.Publisher;
import lombok.Setter;

@Setter
public class PublisherRequest {
    private String name;
    private String telephone;

    public Publisher toPublisher() {
        var publisher = new Publisher();

        publisher.setName(name);
        publisher.setTelephone(telephone);

        return publisher;
    }
}
