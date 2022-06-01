package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@Component
public class LoadStartData implements ApplicationRunner {
    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public LoadStartData(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    private void saveRolesAndUsers() {
        Role adminRole = new Role(1L,"ADMIN");
        Role userRole = new Role(2L,"USER");
        roleService.saveRole(adminRole);
        roleService.saveRole(userRole);
        User admin = new User("Vasya", "Pupkin", 35,"admin@mail.ru", "admin", List.of("ADMIN", "USER"), List.of(adminRole, userRole));
        User user = new User("Ivan", "Petrov", 30, "user@mail.ru", "user", List.of("USER"), List.of(userRole));
        userService.saveUser(admin);
        userService.saveUser(user);
    }

    @Override
    public void run(ApplicationArguments args) {
        saveRolesAndUsers();
    }
}
