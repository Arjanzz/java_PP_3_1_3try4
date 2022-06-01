package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(Long id);
    User findByUsername(String username);
    void saveUser(User user);
    void deleteById(Long id);
    void update(User user);
}
