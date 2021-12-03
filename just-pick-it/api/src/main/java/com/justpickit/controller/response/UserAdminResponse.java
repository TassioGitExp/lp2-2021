package com.justpickit.controller.response;

import com.justpickit.core.domain.UserAdmin;
import lombok.Getter;

@Getter
public class UserAdminResponse {

    private String id;
    private String username;
    private String email;

    public UserAdminResponse fromUser(UserAdmin userAdmin){

        this.id = userAdmin.getId();
        this.email = userAdmin.getEmail();
        this.username = userAdmin.getUsername();

        return this;
    }

}
