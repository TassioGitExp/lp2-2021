package com.justpickit.email.adapters;
import com.justpickit.core.ports.driven_R.email.SendEmailForTokenConfirmationPort;
import com.justpickit.email.SmtpSendEmail;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public record SendEmailForTokenConfirmation(SmtpSendEmail smtpSendEmail) implements SendEmailForTokenConfirmationPort{

    @Override
    public void apply(String email, String token) {
       smtpSendEmail.apply(Set.of(email), "Just Pick It account confirmation", token);
    }

}
