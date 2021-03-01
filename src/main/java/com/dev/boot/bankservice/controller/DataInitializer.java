package com.dev.boot.bankservice.controller;

import com.dev.boot.bankservice.model.Role;
import com.dev.boot.bankservice.model.User;
import com.dev.boot.bankservice.service.RoleService;
import com.dev.boot.bankservice.service.UserService;
import java.time.LocalDate;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void addData() {
        Role roleUser = new Role();
        roleUser.setRoleName(Role.RoleName.USER);
        roleService.save(roleUser);
        Role roleAdmin = new Role();
        roleAdmin.setRoleName(Role.RoleName.ADMIN);
        roleService.save(roleAdmin);

        User userAdmin = new User();
        userAdmin.setName("admin");
        userAdmin.setPhoneNumber("99999999");
        userAdmin.setPassword("123456");
        userAdmin.setDateOfBirth(LocalDate.of(1990,10,10));
        userAdmin.setRoles(Set.of(roleAdmin, roleUser));
        userService.create(userAdmin);
    }
}
