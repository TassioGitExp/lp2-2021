package com.justpickit.core.us.userUS;

import com.justpickit.core.domain.User;
import com.justpickit.core.ports.driven_R.repository.UserRepositoryPort;
import com.justpickit.core.ports.driver_L.userPorts.FindUserByUsernamePort;
import org.springframework.stereotype.Service;

@Service
public record FindUserByUsernameUS(UserRepositoryPort userRepositoryPort) implements FindUserByUsernamePort {

    @Override
    public User apply(String username){
        return userRepositoryPort.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found!"));
    }
}
