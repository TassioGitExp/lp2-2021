package com.justpickit.repository;

import com.justpickit.core.domain.UserAdmin;
import com.justpickit.core.ports.driven_R.repository.UserAdminRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAdminRepository extends MongoRepository<UserAdmin, String>, UserAdminRepositoryPort {
}
