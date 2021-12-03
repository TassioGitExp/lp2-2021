package com.justpickit.core.us.userAdminUS;


import com.justpickit.core.domain.UserAdmin;
import com.justpickit.core.ports.driven_R.repository.UserAdminRepositoryPort;
import com.justpickit.core.ports.driver_L.userAdminPorts.CreateUserAdminPort;
import org.springframework.stereotype.Service;

@Service
public record CreateUserAdminUS(UserAdminRepositoryPort userAdminRepositoryPort) implements CreateUserAdminPort {

    @Override
    public UserAdmin apply(UserAdmin userAdmin) {

        //Nome precisa ser unico
        if (userAdminRepositoryPort.existsByUsername(userAdmin.getUsername()))
            throw new IllegalStateException("Invalid username");

        //Email precisa ser unico
        if (userAdminRepositoryPort.existsByEmail(userAdmin.getEmail()))
            throw new IllegalStateException("Invalid username");

        userAdmin = userAdminRepositoryPort.save(userAdmin);

        return userAdmin;
    }

}
