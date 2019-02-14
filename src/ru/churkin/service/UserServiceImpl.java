package ru.churkin.service;

import ru.churkin.api.ServiceLocator;
import ru.churkin.entity.User;
import ru.churkin.repository.UserRepository;

import java.util.Map;

public class UserServiceImpl {

    public User currentUser = null;

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean createNewUser(User user) {
     String userName = user.getName();
     String userPassword = user.getPassword();
     boolean isConsist = false;
     if (userName.equals("") || userPassword.equals("")) {
         return false;
     } else {
         for (Map.Entry<String, User> entry : userRepository.getUserMap().entrySet()) {
             if (!isConsist && userName.equals(entry.getValue().getName())) {
                 isConsist = true;
             }
         }
     }
     if (isConsist) { return false; }
     else {
         userRepository.createUser(user);
         return true;
     }
    }

    public User findUserById(String id) {
        return (userRepository.findUserById(id));
    }

    public boolean isExist(String userName) {
        boolean isTrue = false;
        for (Map.Entry<String, User> entry : userRepository.getUserMap().entrySet()) {
            if (userName.equals(entry.getValue().getName())) {
                isTrue = true;
            }
        }
        return isTrue;
    }

    public boolean validateUser(User user) {
        String userName = user.getName();
        String userPassword = user.getPassword();
        Boolean isValidate = false;
        for (Map.Entry<String, User> entry : userRepository.getUserMap().entrySet()) {
            if (userName.equals(entry.getValue().getName())
                && userPassword.equals(entry.getValue().getPassword())) {
                isValidate = true;
            }
        }
        return isValidate;
    }

    // Todo - реализовать метод:

    public User getUserByName(String name) {
     User user = new User();
        return user;
    }
}
