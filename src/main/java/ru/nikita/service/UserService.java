package ru.nikita.service;

import ru.nikita.model.User;

import java.util.List;

public interface UserService {
    void create(User user);
    void edit(User user);
    void delete(int id);
    User getUser(int id);
    List<User> index();
}
