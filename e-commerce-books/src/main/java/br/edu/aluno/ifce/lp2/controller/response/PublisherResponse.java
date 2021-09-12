package br.edu.aluno.ifce.lp2.controller.response;

import br.edu.aluno.ifce.lp2.model.entities.Publisher;
import lombok.Getter;

@Getter
public class PublisherResponse {
    private String id;
    private String name;
    private String telephone;

    public PublisherResponse fromPublisher(Publisher publisher) {
        this.id = publisher.getId();
        this.name = publisher.getName();
        this.telephone = publisher.getTelephone();

        return this;
    }
}
