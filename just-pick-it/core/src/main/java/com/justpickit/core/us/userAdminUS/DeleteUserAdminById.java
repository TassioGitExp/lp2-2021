package com.justpickit.core.us.userAdminUS;

import com.justpickit.core.ports.driven_R.repository.UserAdminRepositoryPort;
import com.justpickit.core.ports.driver_L.userAdminPorts.DeleteUserAdminByIdPort;
import org.springframework.stereotype.Service;

@Service
public record DeleteUserAdminById(UserAdminRepositoryPort userAdminRepositoryPort) implements DeleteUserAdminByIdPort {

    @Override
    public void apply (String id) {
        userAdminRepositoryPort.deleteById(id);
    }

}
