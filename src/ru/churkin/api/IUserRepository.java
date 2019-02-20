package ru.churkin.api;

import ru.churkin.entity.User;

import java.util.Map;

public interface IUserRepository {

    public void createUser(User user);

    public User findUserByName(String name);

    public User findUserById(String id);

    public void updateUser(String id, User user);

    public void deleteUser(String id);

    public Map<String, User> getUserMap();

}
