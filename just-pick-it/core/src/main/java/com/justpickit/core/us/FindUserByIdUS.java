package com.justpickit.core.us;

import com.justpickit.core.domain.User;
import com.justpickit.core.ports.driven_R.repository.UserRepositoryPort;
import com.justpickit.core.ports.driver_L.FindUserByIdPort;
import org.springframework.stereotype.Service;

@Service
public record FindUserByIdUS(UserRepositoryPort userRepositoryPort) implements FindUserByIdPort {

    @Override
    public User apply(String id) {
        return userRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found!"));
    }

}
