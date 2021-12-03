package com.justpickit.controller.request;

import com.justpickit.core.domain.UserAdmin;
import lombok.Setter;

@Setter
public class UserAdminRequest {

    private String username;
    private String email;
    private String password;

    public UserAdmin toUser(){
        var userAdmin = new UserAdmin();

        userAdmin.setUsername(username);
        userAdmin.setEmail(email);
        userAdmin.setPassword(password);

        return userAdmin;
    }

}
