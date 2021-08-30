package br.edu.aluno.ifce.lp2.model.services;

import br.edu.aluno.ifce.lp2.model.entities.User;
import br.edu.aluno.ifce.lp2.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void create(User user) {
        if(!userRepository.existsByName(user.getName())) {
            userRepository.save(user);
        }
    }

    public void update(String id, User user) {
        var canUpdate = this.getById(id) != null;

        if(canUpdate) {
            userRepository.save(user);
        }
    }

    public Collection<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(String id) {
        return userRepository.findById(id).orElse(new User());
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
