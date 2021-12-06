package com.justpickit.core.ports.driven_R.repository;
import com.justpickit.core.domain.User;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

public interface UserRepositoryPort {

    User save (User user);

    boolean existsByEmail (String email);

    boolean existsByUsername (String username);

    Optional<User> findById (String id);

    User findByTokenValue(String token);

    void deleteById (String id);

}
