package ru.churkin.repository;

import ru.churkin.api.IUserRepository;
import ru.churkin.entity.User;

import java.sql.*;
import java.util.Map;
import java.util.UUID;

import static ru.churkin.Bootstrap.*;

public class UserRepositoryDB implements IUserRepository {

   public static final String CREATE_USER = "insert into users (id, name, password) values ('?', '?', '?');";
   public static final String FIND_USER_BY_NAME = "select * from users where name = '?';";
   public static final String FIND_USER_BY_ID = "select * from users where id = '?';";
   public static final String UPDATE_USER = "update users set name = '?', password = '?' where id = '?';";
   public static final String DELETE_USER = "delete from users where id = '?';";
   public static final String GET_ALL_USERS = "select * from users;";

    @Override
    public void createUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        try (Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
             PreparedStatement ps = connection.prepareStatement(CREATE_USER)){
            ps.setString(1, id);
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findUserByName(String name) {
        User user = null;
        try
        (Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
        PreparedStatement ps = connection.prepareStatement(FIND_USER_BY_NAME)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()){
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
            catch  (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findUserById(String id) {
        User user = null;
        try (Connection connection = DriverManager.getConnection(FIND_USER_BY_ID)) {
             PreparedStatement ps = connection.prepareStatement(FIND_USER_BY_ID);
             ps.setString(1, id);
             ResultSet rs = ps.executeQuery();
             user.setId(rs.getString("id"));
             user.setName(rs.getString("name"));
             user.setName(rs.getString("password"));
             rs.close();
             ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateUser(String id, User user) {
        try (Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD)) {
            PreparedStatement ps = connection.prepareStatement(UPDATE_USER);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String id) {
        try (Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD)){
            PreparedStatement ps = connection.prepareStatement(DELETE_USER);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, User> getUserMap() {
        Map<String, User> userMap = null;
        try {
            Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
            PreparedStatement ps = connection.prepareStatement(GET_ALL_USERS);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs.getString("id"));
            while (rs.next()) {
                userMap.put(rs.getString("id"),
                        new User(rs.getString("id"),
                                rs.getString("name"),
                                rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userMap;
    }
}