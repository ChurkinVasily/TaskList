package ru.churkin.repository;

import ru.churkin.api.IUserRepository;
import ru.churkin.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserRepositoryInMem implements IUserRepository {

    private Map<String, User> userMap = new HashMap<>();

    {
        userMap.put("u1", new User("u1", "user1", "pass1"));
        userMap.put("u2", new User("u2", "user2", "pass2"));
        userMap.put("u3", new User("u3", "user3", "pass3"));
    }

    public void createUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        userMap.put(id, user);
    }

    public User findUserByName(String name) {
        User user = null;
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                user = entry.getValue();
            }
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
