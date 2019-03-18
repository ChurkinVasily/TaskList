package ru.churkin.tm.service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.churkin.tm.api.UserService;
import ru.churkin.tm.entity.User;
import ru.churkin.tm.repository.UserRepositoryDS;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.UUID;

//@ApplicationScoped
@Transactional
public class UserServiceJPA implements UserService {

//    @Inject
//    private EntityManagerFactory entityManagerFactory;

    @Inject
    private UserRepositoryDS userRepository;

    private User currentUser;

    @Override
    public boolean createNewUser(String name, String pass) {
        User user = new User(name, pass);
        return createNewUser(user);
    }

    @Override
    public boolean createNewUser(User user) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        userRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        String userName = user.getName();
        String userPassword = user.getPassword();
        boolean isConsist = false;
        if (userName.isEmpty() || userPassword.isEmpty()) {
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
//        entityManager.getTransaction().commit();
//        entityManager.close();
        return true;
    }

    @Override
    public User findUserById(String id) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        userRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        User user = userRepository.findBy(id);
//        entityManager.close();
        return user;
    }

    @Override
    public User findUserByName(String userName) throws SQLException {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        userRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        User user = userRepository.findUserByName(userName);
//        entityManager.close();
        return user;
    }



    ///// ---- метод не должен быть транзакционным ???? не закрывать транзакцию в нем!!!
    @Override
    public boolean isExist(String userName) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        userRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        boolean isTrue = false;
        for (User cUser : userRepository.findAll()) {
            if (userName.equals(cUser.getName())) {
                isTrue = true;
                break;
            }
        }
//        entityManager.close();
        return isTrue;
    }


    @Override
    public boolean validateUser(User user) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        userRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        if (user == null) return false;
        String userName = user.getName();
        String userPassword = user.getPassword();
        for (User cUser : userRepository.findAll()) {
            if (userName != null && userName.equals(cUser.getName())
                    && userPassword.equals(cUser.getPassword())) {
                return true;
            }
        }
//        entityManager.close();
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
    public void getUserByName(String userName) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        userRepository.setEntityManager(entityManager);
        if (isExist(userName)) {
            currentUser = userRepository.findUserByName(userName);
        }
//        entityManager.close();
    }
}
