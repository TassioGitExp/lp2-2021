package com.justpickit.core.ports.driven_R.repository;
import com.justpickit.core.domain.UserAdmin;

import java.util.Optional;

public interface UserAdminRepositoryPort {

    UserAdmin save (UserAdmin userAdmin);

    boolean existsByEmail (String email);

    boolean existsByUsername (String username);

    Optional<UserAdmin> findById (String id);

    void deleteById (String id);

}
