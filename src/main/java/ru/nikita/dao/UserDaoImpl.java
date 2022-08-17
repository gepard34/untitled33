package ru.nikita.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.nikita.model.User;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void edit(int id, User user) {
        User userToUpdate = entityManager.find(User.class, id);
        userToUpdate.setName(user.getName());
        userToUpdate.setSurname(user.getSurname());
        userToUpdate.setEmail(user.getEmail());
    }

    @Transactional
    public void delete(int id) {
        User userToDelete = entityManager.find(User.class, id);
        entityManager.remove(userToDelete);
    }

    @Transactional
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public List<User> index() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}
