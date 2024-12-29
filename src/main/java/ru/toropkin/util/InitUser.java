package ru.toropkin.util;

/*
generation first user for test security
 */

import org.springframework.stereotype.Component;
import ru.toropkin.entity.Role;
import ru.toropkin.entity.User;
import ru.toropkin.repositories.RoleRepository;
import ru.toropkin.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitUser {

    private final UserService userService;
    private final RoleRepository roleRepository;

    public InitUser(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void generation() {

        System.out.println("DEBUG: user list empty: "+userService.findAll().isEmpty());     // DEBUG line

        if (userService.findAll().isEmpty()) {


            Role admin = roleRepository.getById(2);
            Role user = roleRepository.getById(1);

            //User have role: ADMIN, USER
            Set<Role> roles = new HashSet<>();
            roles.add(admin);
            roles.add(user);
            User userAdmin = new User();
            userAdmin.setFirstName("Evgeniy");
            userAdmin.setLastName("Petrov");
            userAdmin.setAge(29);
            userAdmin.setEmail("test1@test.test");
            userAdmin.setPassword("test");
            userAdmin.setRoles(roles);

            // User have role: USER
            Set<Role> roles1 = new HashSet<>();
            roles1.add(user);
            User userNotAdmin = new User();
            userNotAdmin.setFirstName("Mikhail");
            userNotAdmin.setLastName("Dmitriev");
            userNotAdmin.setAge(28);
            userNotAdmin.setEmail("test12@test.test");
            userNotAdmin.setPassword("test");
            userNotAdmin.setRoles(roles1);

            userService.save(userAdmin);
            userService.save(userNotAdmin);

        }
    }
}
