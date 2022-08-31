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


    public void create(User user) {
        entityManager.persist(user);
    }


    public void edit(User user) {
        entityManager.merge(user);
    }


    public void delete(int id) {
        User userToDelete = entityManager.find(User.class, id);
        entityManager.remove(userToDelete);
    }


    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }


    public List<User> index() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}
