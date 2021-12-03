package com.justpickit.core.us.userAdminUS;

import com.justpickit.core.domain.UserAdmin;
import com.justpickit.core.ports.driven_R.repository.UserAdminRepositoryPort;
import com.justpickit.core.ports.driver_L.userAdminPorts.FindUserAdminByIdPort;
import org.springframework.stereotype.Service;

@Service
public record FindUserAdminByIdUS(UserAdminRepositoryPort userAdminRepositoryPort) implements FindUserAdminByIdPort {

    @Override
    public UserAdmin apply(String id){
        return userAdminRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found!"));
    }
}