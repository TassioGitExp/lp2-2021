package com.justpickit.email;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public record SmtpSendEmail(JavaMailSender javaMailSender) {

    public void apply(Set<String> receiver, String subject, String body) {

        try {

            var message = new SimpleMailMessage();
            message.setFrom("Just Pick It <lp2mail.sender@gmail.com>");
            message.setTo(receiver.toArray(new String[0]));
            message.setSubject(subject);
            message.setText(body);

            javaMailSender.send(message);

        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}
