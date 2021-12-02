package com.justpickit.core.us;

import com.justpickit.core.domain.User;
import com.justpickit.core.ports.driven_R.email.SendEmailForTokenConfirmationPort;
import com.justpickit.core.ports.driven_R.repository.UserRepositoryPort;
import com.justpickit.core.ports.driver_L.CreateUserPort;
import org.springframework.stereotype.Service;

@Service
public record CreateUserUS(/*SendEmailForTokenConfirmationPort sendEmailForTokenConfirmationPort,*/
                           UserRepositoryPort userRepositoryPort) implements CreateUserPort {

    @Override
    public User apply (User user){

        //Verifica se email existe;
        if (userRepositoryPort.existsByEmail(user.getEmail()))
            throw new IllegalStateException("invalid email!");
        //Verificar se username existe;
        if (userRepositoryPort.existsByUsername(user.getUsername()))
            throw new IllegalStateException("Invalid username!");
        //Gerar token;
        //Enviar email de confirmação;

        //Salvar no banco de daddos;
        user = userRepositoryPort.save(user);

        return user;
    }

}
