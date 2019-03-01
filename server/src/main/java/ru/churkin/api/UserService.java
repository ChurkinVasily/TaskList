package ru.churkin.api;

import ru.churkin.dto.User;

import java.sql.SQLException;

public interface UserService {

    boolean createNewUser(User user) throws SQLException;

    User findUserById(String id) throws SQLException;

    boolean isExist(String userName) throws SQLException;

    boolean validateUser(User user) throws SQLException;

    User getCurrentUser();

    void getUserByName(String userName) throws SQLException;


}
