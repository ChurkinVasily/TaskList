package ru.churkin.tm.api;

import ru.churkin.tm.entity.User;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {

    void setEntityManager(EntityManager entityManager);

    void createUser(User user) throws SQLException;

    User findUserByName(String name) throws SQLException;

    User findUserById(String id) throws SQLException;

    void updateUser(String id, User user) throws SQLException;

    void deleteUser(String id) throws SQLException;

    List<User> getUserList() throws SQLException;

}
