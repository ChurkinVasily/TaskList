package ru.churkin.repository;

import ru.churkin.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserRepository {

    private Map<String, User> userMap = new HashMap<>();

    public void createUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        userMap.put(id, user);
    }

    public User findUserByName(String name) {
        User user = new User();
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                user = entry.getValue();
            }
            else user = null;
        }
        return user;
    }

    public User findUserById(String id) {
        return userMap.get(id);
    }

    public void updateUser(String id, User user) {
        userMap.put(id, user);
    }

    public void deleteUser(String id) {
        userMap.remove(id);
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

}
