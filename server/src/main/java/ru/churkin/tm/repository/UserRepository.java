package ru.churkin.tm.repository;

import ru.churkin.tm.api.IUserRepository;
import ru.churkin.tm.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@ApplicationScoped
public class UserRepository implements IUserRepository {

    EntityManager entityManager;

//    private EntityManager entityManager;
//    public UserRepository(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUserByName(String name) {
        return entityManager.createQuery("select e from User e where e.name = :userName", User.class)
                .setParameter("userName", name)
                .getSingleResult();

    }

    @Override
    public User findUserById(String id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(String id, User user) {
        entityManager.refresh(user);
    }

    @Override
    public void deleteUser(String id) {
        entityManager.remove(id);
    }

    @Override
    public List<User> getUserList() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
}
