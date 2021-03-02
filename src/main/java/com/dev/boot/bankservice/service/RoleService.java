package com.dev.boot.bankservice.service;

import com.dev.boot.bankservice.model.Role;

public interface RoleService {
    Role save(Role role);

    Role getByName(String name);
}
