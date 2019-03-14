package ru.churkin.tm.api;

import ru.churkin.tm.entity.User;

import java.sql.SQLException;

public interface UserService {

    boolean createNewUser(User user) throws SQLException;

    boolean createNewUser(String name, String pass) throws SQLException;

    User findUserById(String id) throws SQLException;

    User findUserByName(String userName) throws SQLException;

    boolean isExist(String userName) throws SQLException;

    boolean validateUser(User user) throws SQLException;

    boolean validateUser(String name, String pass);

    User getCurrentUser();

    void setCurrentUser(User user);

    void getUserByName(String userName) throws SQLException;


}
