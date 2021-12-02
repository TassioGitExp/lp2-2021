package com.justpickit.controller.request;

import com.justpickit.core.domain.User;
import lombok.Setter;

@Setter
public class UserRequest {

    private String username;
    private String email;
    private String password;

    public User toUser(){
        var user = new User();

        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }

}
