package com.justpickit.core.us.userUS;

import com.justpickit.core.domain.Token;
import com.justpickit.core.domain.User;
import com.justpickit.core.ports.driven_R.email.SendEmailForTokenConfirmationPort;
import com.justpickit.core.ports.driven_R.repository.UserRepositoryPort;
import com.justpickit.core.ports.driver_L.userPorts.CreateUserPort;
import org.springframework.stereotype.Service;

@Service                    //Falta criar a port do email
public record CreateUserUS(SendEmailForTokenConfirmationPort sendEmailForTokenConfirmationPort,
                           UserRepositoryPort userRepositoryPort) implements CreateUserPort {

    @Override
    public User apply (User user){

        //Verifica se email existe;
        if (userRepositoryPort.existsByEmail(user.getEmail()))
            throw new IllegalStateException("Email not available!");
        //Verificar se username existe;
        if (userRepositoryPort.existsByUsername(user.getUsername()))
            throw new IllegalStateException("Invalid username!");

        //Gerar token;
        user.setToken(new Token(8));

        //Salvar no banco de daddos;
        user = userRepositoryPort.save(user);

        //Enviar email de confirmação;
        sendEmailForTokenConfirmationPort.apply(user.getEmail(),user.getToken().getValue());

        return user;
    }

}
