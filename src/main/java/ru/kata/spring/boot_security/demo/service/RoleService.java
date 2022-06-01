package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    List<Role> findByName(List<String> name);
    void saveRole(Role role);
}
