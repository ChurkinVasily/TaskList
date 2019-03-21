package ru.churkin.tm.service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.churkin.tm.api.UserService;
import ru.churkin.tm.entity.User;
import ru.churkin.tm.repository.UserRepositoryDS;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Logger;

@Transactional
public class UserServiceJPA implements UserService {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private UserRepositoryDS userRepository;

    private User currentUser;

    @Override
    public boolean createNewUser(@Nullable final String name, @Nullable final String pass) {
        logger.info("-------------------------create new user method");
        if (name == null || name.isEmpty() || pass == null || pass.isEmpty()) return false;
        User user = new User(name, pass);
        return createNewUser(user);
    }

    @Override
    public boolean createNewUser(User user) {
        logger.info("-------------------create new user method user");
        final String userId = UUID.randomUUID().toString();
        user.setId(userId);
        final String userName = user.getName();
        final String userPassword = user.getPassword();
        boolean isConsist = false;
        if (userName == null || userName.isEmpty() || userPassword == null || userPassword.isEmpty()) {
            return false;
        }
        for (User cUser : userRepository.findAll()) {
            if (!isConsist && userName.equals(cUser.getName())) {
                isConsist = true;
            }
        }
        if (isConsist) {
            return false;
        }
        userRepository.persist(user);
        return true;
    }

    @Override
    public User findUserById(@Nullable final String id) {
        logger.info("-----------------------------find user by id start");
        if (id == null || id.isEmpty()) return null;
        User user = userRepository.findBy(id);
        logger.info("---------------------------find user by id " + user);
        return user;
    }

    @Nullable
    @Override
    public User findUserByName(@Nullable final String userName) throws SQLException {
        logger.info("-----------------------------------find user by name");
        if (userName == null || userName.isEmpty()) return null;
        User user = userRepository.findUserByName(userName);
        logger.info("--------------------------------find user by name" + user);
        return user;
    }

    @Override
    public boolean isExist(@Nullable final String userName) {
        if (userName == null || userName.isEmpty()) return false;
        logger.info("--------------------------------------isExist");
        boolean isTrue = false;
        for (User cUser : userRepository.findAll()) {
            if (userName.equals(cUser.getName())) {
                isTrue = true;
                break;
            }
        }
        logger.info("--------------------------------------isExist " + isTrue);
        return isTrue;
    }

    @Override
    public boolean validateUser(User user) {
        logger.info("--------------------------------------validate user");
        if (user == null) return false;
        String userName = user.getName();
        String userPassword = user.getPassword();
        for (User cUser : userRepository.findAll()) {
            if (userName != null && userName.equals(cUser.getName())
                    && userPassword.equals(cUser.getPassword())) {
                logger.info("--------------------------------------validate user true");
                return true;
            }
        }
        logger.info("--------------------------------------validate user false");
        return false;
    }

    @Override
    public boolean validateUser(String name, String pass) {
        User user = new User(name, pass);
        return validateUser(user);
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    @Override
    public void getUserByName(@Nullable final String userName) {
        logger.info("--------------------------------------get user by name");
        if (userName == null || userName.isEmpty()) return;
        if (isExist(userName)) {
            currentUser = userRepository.findUserByName(userName);
        }
        logger.info("--------------------------------------get user by name finish");
    }
}
