package com.justpickit.core.ports.driven_R.repository;
import com.justpickit.core.domain.UserAdmin;

import java.util.Optional;

public interface UserAdminRepositoryPort {

    public UserAdmin save (UserAdmin userAdmin);

    public boolean existsByEmail (String email);

    public boolean existsByUsername (String username);

    public boolean existsById (String id);

    public Optional<UserAdmin> findById (String id);

    public Optional<UserAdmin> findByUsername (String username);

    public Optional<UserAdmin> findByEmail (String email);

    void deleteById (String id);

}
