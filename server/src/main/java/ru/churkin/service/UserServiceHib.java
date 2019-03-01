package ru.churkin.service;

import ru.churkin.api.UserService;
import ru.churkin.dto.User;

import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;

public class UserServiceHib implements UserService {

    private EntityManagerFactory entityManagerFactory;

    public UserServiceHib(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public boolean createNewUser(User user) throws SQLException {
        return false;
    }

    @Override
    public User findUserById(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean isExist(String userName) throws SQLException {
        return false;
    }

    @Override
    public boolean validateUser(User user) throws SQLException {
        return false;
    }

    @Override
    public User getCurrentUser() {
        return null;
    }

    @Override
    public void getUserByName(String userName) throws SQLException {

    }
}
