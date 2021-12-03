package com.justpickit.core.us.userUS;

import com.justpickit.core.ports.driven_R.repository.UserRepositoryPort;
import com.justpickit.core.ports.driver_L.userPorts.DeleteUserByIdPort;
import org.springframework.stereotype.Service;

@Service
public record DeleteUserByIdUS(UserRepositoryPort userRepositoryPort) implements DeleteUserByIdPort {

    @Override
    public void apply(String id) {
        userRepositoryPort.deleteById(id);
    }
}
