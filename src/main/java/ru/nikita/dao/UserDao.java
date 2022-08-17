package ru.nikita.dao;

import ru.nikita.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);
    void edit(int id, User user);
    void delete(int id);
    User show(int id);
    List<User> index();
}
