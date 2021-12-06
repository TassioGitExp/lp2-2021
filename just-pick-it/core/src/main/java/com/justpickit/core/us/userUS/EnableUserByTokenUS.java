package com.justpickit.core.us.userUS;

import com.justpickit.core.ports.driven_R.repository.UserRepositoryPort;
import com.justpickit.core.ports.driver_L.userPorts.EnableUserByTokenPort;
import org.springframework.stereotype.Service;

@Service
public record EnableUserByTokenUS(UserRepositoryPort userRepositoryPort) implements EnableUserByTokenPort {

    @Override
    public void apply(String token) {
        var user = userRepositoryPort.findByTokenValue(token);

        if(user != null && user.getToken().notExpired()){
            user.setEnabled(true);
            user.setToken(null);
        }

        userRepositoryPort.save(user);

    }

}
