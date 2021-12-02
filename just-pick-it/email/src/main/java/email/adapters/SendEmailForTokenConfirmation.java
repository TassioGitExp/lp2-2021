package email.adapters;
import com.justpickit.core.ports.driven_R.email.SendEmailForTokenConfirmationPort;
import org.springframework.stereotype.Service;

@Service
public record SendEmailForTokenConfirmation() implements SendEmailForTokenConfirmationPort{

    @Override
    public void apply(String email, String token) {
       // sendEmail.apply(Set.of(email), "Email for confirmation!", token);
    }

}
