package ru.churkin.repository;

import ru.churkin.api.IUserRepository;
import ru.churkin.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepository implements IUserRepository {

    private EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User createUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User findUserByName(String name) {
        return entityManager.createQuery("select e from User e where e.name = :userName", User.class)
                .setParameter("userName", name)
                .getSingleResult();
    }

    @Override
    public User findUserById(String id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(String id, User user) {
        entityManager.refresh(user);
    }

    @Override
    public void deleteUser(String id) {
        entityManager.remove(id);
    }

    @Override
    public List<User> getUserList() {
        return entityManager.createQuery("select e from User ", User.class)
                .getResultList();
    }
}
