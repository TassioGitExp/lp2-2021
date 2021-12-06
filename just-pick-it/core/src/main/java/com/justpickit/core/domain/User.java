package com.justpickit.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String id;
    private String username;
    private String email;
    private String password;
    private boolean enabled;

    private Token token;

}
