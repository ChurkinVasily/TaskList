package ru.churkin.service;

import ru.churkin.api.UserService;
import ru.churkin.entity.User;
import ru.churkin.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

public class UserServiceHib implements UserService {

    private EntityManagerFactory entityManagerFactory;
    private User currentUser;

    public UserServiceHib(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public boolean createNewUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserRepository userRepository = new UserRepository(entityManager);
        entityManager.getTransaction().begin();
        String userId = UUID.randomUUID().toString();
        user.setId(userId);
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
        if (isConsist) {
            entityManager.getTransaction().rollback();
            return false;
        } else {
            userRepository.createUser(user);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
    }

    @Override
    public User findUserById(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserRepository userRepository = new UserRepository(entityManager);
        entityManager.getTransaction().begin();
        User user = userRepository.findUserById(id);
        entityManager.close();
        return user;
    }

    @Override
    public boolean isExist(String userName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserRepository userRepository = new UserRepository(entityManager);
        entityManager.getTransaction().begin();
        boolean isTrue = false;
        for (Map.Entry<String, User> entry : userRepository.getUserMap().entrySet()) {
            if (userName.equals(entry.getValue().getName())) {
                isTrue = true;
            }
        }
        entityManager.close();
        return isTrue;
    }

    @Override
    public boolean validateUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserRepository userRepository = new UserRepository(entityManager);
        entityManager.getTransaction().begin();
        if (user != null) {
            String userName = user.getName();
            String userPassword = user.getPassword();
            boolean isValidate = false;
            for (Map.Entry<String, User> entry : userRepository.getUserMap().entrySet()) {
                if (userName != null && userName.equals(entry.getValue().getName())
                        && userPassword.equals(entry.getValue().getPassword())) {
                    isValidate = true;
                }
            }
            entityManager.close();
            return isValidate;
        } else return false;
    }


    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void getUserByName(String userName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserRepository userRepository = new UserRepository(entityManager);
        entityManager.getTransaction().begin();
        if (isExist(userName)) {
            currentUser = userRepository.findUserByName(userName);
        }
        entityManager.close();
    }
}
