package br.edu.aluno.ifce.lp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import br.edu.aluno.ifce.lp2.model.services.UserService;
import br.edu.aluno.ifce.lp2.model.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void post(@RequestBody User user) {
        userService.create(user);
    }

    @GetMapping
    public Collection<User> get() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable String id) {
        return  userService.getById(id);
    }

    @PutMapping("{id}")
    public void put(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        userService.update(id, user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }
}
