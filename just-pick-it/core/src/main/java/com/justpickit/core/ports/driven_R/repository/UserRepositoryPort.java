package com.justpickit.core.ports.driven_R.repository;
import com.justpickit.core.domain.User;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

public interface UserRepositoryPort {

    public User save (User user);

    public boolean existsByEmail (String email);

    public boolean existsByUsername (String username);

    public boolean existsById (String id);

    public Optional<User> findById (String id);

    public Optional<User> findByUsername (String username);

    public Optional<User> findByEmail (String email);

    void deleteById (String id);

}
