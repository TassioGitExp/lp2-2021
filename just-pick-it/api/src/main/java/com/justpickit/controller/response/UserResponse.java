package com.justpickit.controller.response;

import com.justpickit.core.domain.User;
import lombok.Getter;

@Getter
public class UserResponse {

    private String id;
    private String username;
    private String email;

    public UserResponse fromUser(User user){

        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();

        return this;
    }

}
