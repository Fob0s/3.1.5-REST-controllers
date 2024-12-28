package ru.toropkin.service;

import org.springframework.stereotype.Service;
import ru.toropkin.entity.Role;
import ru.toropkin.entity.UserRole;
import ru.toropkin.repositories.RoleRepository;

import javax.annotation.PostConstruct;

@Service
public class RolesDataInit {

    private final RoleRepository roleRepository;

    public RolesDataInit(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void initValueInDataBase() {
        if (roleRepository.count() == 0) {
            for (UserRole rolename : UserRole.values()) {
                Role role = new Role();
                role.setUserRole(rolename);
                roleRepository.save(role);
            }
        }
    }

}
