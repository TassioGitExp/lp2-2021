package com.justpickit.core.us.userAdminUS;


import com.justpickit.core.domain.UserAdmin;
import com.justpickit.core.ports.driven_R.email.SendEmailForTokenConfirmationPort;
import com.justpickit.core.ports.driven_R.repository.UserAdminRepositoryPort;
import com.justpickit.core.ports.driver_L.userAdminPorts.CreateUserAdminPort;
import org.springframework.stereotype.Service;

@Service
public record CreateUserAdminUS(SendEmailForTokenConfirmationPort sendEmailForTokenConfirmationPort,
                                UserAdminRepositoryPort userAdminRepositoryPort) implements CreateUserAdminPort {

    @Override
    public UserAdmin apply(UserAdmin userAdmin) {

        if (userAdminRepositoryPort.existsByUsername(userAdmin.getUsername()))
            throw new IllegalStateException("Invalid username");

        if (userAdminRepositoryPort.existsByEmail(userAdmin.getEmail()))
            throw new IllegalStateException("Invalid username");

        sendEmailForTokenConfirmationPort.apply(userAdmin.getEmail(), "12345");

        userAdmin = userAdminRepositoryPort.save(userAdmin);

        return userAdmin;
    }

}
