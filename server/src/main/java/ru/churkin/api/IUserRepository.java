package ru.churkin.api;

import ru.churkin.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IUserRepository {

    void createUser(User user) throws SQLException;

    User findUserByName(String name) throws SQLException;

    User findUserById(String id) throws SQLException;

    void updateUser(String id, User user) throws SQLException;

    void deleteUser(String id) throws SQLException;

    List<User> getUserList() throws SQLException;

}
