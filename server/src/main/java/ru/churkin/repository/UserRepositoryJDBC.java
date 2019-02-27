package ru.churkin.repository;

import ru.churkin.api.IUserRepository;
import ru.churkin.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserRepositoryJDBC implements IUserRepository {

    private Connection connection;

    public UserRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    public UserRepositoryJDBC() {
    }

    public static final String CREATE_USER = "insert into users (id, name, password) values (?, ?, ?);";
    public static final String FIND_USER_BY_NAME = "select * from users where name = ?;";
    public static final String FIND_USER_BY_ID = "select * from users where id = ?;";
    public static final String UPDATE_USER = "update users set name = ?, password = ? where id = ?;";
    public static final String DELETE_USER = "delete from users where id = ?;";
    public static final String GET_ALL_USERS = "select * from users;";

    @Override
    public void createUser(User user) throws SQLException {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        PreparedStatement ps = connection.prepareStatement(CREATE_USER);
        ps.setString(1, id);
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public User findUserByName(String name) throws SQLException {
        User user = new User();
        PreparedStatement ps = connection.prepareStatement(FIND_USER_BY_NAME);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        rs.first();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        rs.close();
        ps.close();
        return user;
    }

    @Override
    public User findUserById(String id) throws SQLException {
        User user = null;
        PreparedStatement ps = connection.prepareStatement(FIND_USER_BY_ID);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setName(rs.getString("password"));
        rs.close();
        ps.close();
        return null;
    }

    @Override
    public void updateUser(String id, User user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_USER);
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, id);
        ps.executeUpdate();
        ps.close();

    }

    @Override
    public void deleteUser(String id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_USER);
        ps.setString(1, id);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public Map<String, User> getUserMap() throws SQLException {
        Map<String, User> userMap = new HashMap<>();
        PreparedStatement ps = connection.prepareStatement(GET_ALL_USERS);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            userMap.put(rs.getString("id"),
                    new User(rs.getString("id"),
                            rs.getString("name"),
                            rs.getString("password")));
        }
        rs.close();
        ps.close();
        return userMap;
    }
}
