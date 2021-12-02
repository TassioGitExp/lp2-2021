package com.justpickit.core.ports.driven_R.email;

import org.springframework.context.annotation.Bean;

public interface SendEmailForTokenConfirmationPort {

    void apply (String email, String token);

}