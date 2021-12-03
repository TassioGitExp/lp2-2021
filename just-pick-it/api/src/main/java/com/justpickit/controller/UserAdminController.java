package com.justpickit.controller;

import com.justpickit.controller.request.UserAdminRequest;
import com.justpickit.controller.response.UserAdminResponse;
import com.justpickit.core.ports.driver_L.userAdminPorts.CreateUserAdminPort;
import com.justpickit.core.ports.driver_L.userAdminPorts.DeleteUserAdminByIdPort;
import com.justpickit.core.ports.driver_L.userAdminPorts.FindUserAdminByIdPort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users/admin")
public record UserAdminController(
        CreateUserAdminPort createUserAdminPort,
        FindUserAdminByIdPort findUserAdminByIdPort,
        DeleteUserAdminByIdPort deleteUserAdminByIdPort
) {

    @PostMapping
    public UserAdminResponse post (@RequestBody UserAdminRequest userAdminRequest) {
        var userAdmin =  userAdminRequest.toUser();
        userAdmin = createUserAdminPort.apply(userAdmin);
        return new UserAdminResponse().fromUser(userAdmin);
    }

    @GetMapping("id/{id}")
    public UserAdminResponse get (@PathVariable String id) {
        var userAdmin = findUserAdminByIdPort.apply(id);

        return new UserAdminResponse().fromUser(userAdmin);
    }

    @DeleteMapping("delete/{id}")
    public void delete (@PathVariable String id) {
        deleteUserAdminByIdPort.apply(id);
    }
}
