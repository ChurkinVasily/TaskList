package ru.churkin.repository;

import ru.churkin.api.IUserRepository;
import ru.churkin.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.util.Map;

public class UserRepository implements IUserRepository {

    private EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public User findUserByName(String name) {
        return null;
    }

    @Override
    public User findUserById(String id) {
        return null;
    }

    @Override
    public void updateUser(String id, User user) {

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public Map<String, User> getUserMap() {
        return null;
    }
}
