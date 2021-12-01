package com.justpickit.core.ports.driven_R.email;

public interface SendEmailForTokenConfirmationPort {

    void apply (String email, String token);

}