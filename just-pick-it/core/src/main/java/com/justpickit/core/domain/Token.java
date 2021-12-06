package com.justpickit.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;

@Getter
@Setter
public class Token {

    private String value;
    private LocalDateTime expirationTime;

    public Token(){

    }

    public Token(int n) {
        this.expirationTime = LocalDateTime.now().plusMinutes(30);
        this.value = RandomStringUtils.randomAlphanumeric(n);
    }

    public boolean isExpired() {
        return  this.expirationTime.isBefore(LocalDateTime.now());
    }

    public boolean notExpired() {
        return  !isExpired();
    }

}
