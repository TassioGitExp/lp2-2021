package com.justpickit.core.ports.driver_L.userPorts;

import com.justpickit.core.domain.User;

public interface FindUserByUsernamePort {

    User apply (String username);
}
