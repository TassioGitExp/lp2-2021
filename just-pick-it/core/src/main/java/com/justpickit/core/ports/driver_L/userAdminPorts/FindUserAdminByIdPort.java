package com.justpickit.core.ports.driver_L.userAdminPorts;

import com.justpickit.core.domain.UserAdmin;

public interface FindUserAdminByIdPort {

    UserAdmin apply (String id);

}
