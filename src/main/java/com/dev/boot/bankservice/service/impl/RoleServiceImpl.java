package com.dev.boot.bankservice.service.impl;

import com.dev.boot.bankservice.model.Role;
import com.dev.boot.bankservice.repository.RoleRepository;
import com.dev.boot.bankservice.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String name) {
        return roleRepository.findByRoleName(Role.RoleName.valueOf(name)).get();
    }
}
