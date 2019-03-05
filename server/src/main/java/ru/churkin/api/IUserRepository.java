package ru.churkin.api;

import ru.churkin.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IUserRepository {

    public User createUser(User user) throws SQLException;

    public User findUserByName(String name) throws SQLException;

    public User findUserById(String id) throws SQLException;

    public void updateUser(String id, User user) throws SQLException;

    public void deleteUser(String id) throws SQLException;

    public List<User> getUserList() throws SQLException;

}
