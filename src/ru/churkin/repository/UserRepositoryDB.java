package ru.churkin.repository;

import ru.churkin.api.Command;
import ru.churkin.api.IUserRepository;
import ru.churkin.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import static ru.churkin.Bootstrap.*;

public class UserRepositoryDB implements IUserRepository {

   public static final String CREATE_USER = "insert into users (id, name, password) values ('?', '?', '?');";


    @Override
    public void createUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        try {
            Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
            PreparedStatement ps = connection.prepareStatement(CREATE_USER);
            ps.setString(1, id);
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
