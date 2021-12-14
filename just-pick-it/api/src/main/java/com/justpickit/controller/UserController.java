package com.justpickit.controller;

import com.justpickit.controller.request.UserRequest;
import com.justpickit.controller.response.UserResponse;
import com.justpickit.core.ports.driver_L.userPorts.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public record UserController(
        CreateUserPort createUserPort,
        FindUserByIdPort findUserByIdPort,
        FindUserByUsernamePort findUserByUsernamePort,
        EnableUserByTokenPort enableUserByTokenPort,
        DeleteUserByIdPort deleteUserByIdPort
) {

    @PostMapping
    public UserResponse post(@RequestBody UserRequest userRequest) {

        var user = userRequest.toUser();
        user = createUserPort.apply(user);

        return new UserResponse().fromUser(user);
    }

    @GetMapping("id/{id}")
    public UserResponse findById(@PathVariable String id) {
        var user = findUserByIdPort.apply(id);

        return new UserResponse().fromUser(user);
    }

    @PatchMapping("confirm")
    public void enableUser(@RequestParam String token){
        enableUserByTokenPort.apply(token);

    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable String id) {
        deleteUserByIdPort.apply(id);
    }

}
