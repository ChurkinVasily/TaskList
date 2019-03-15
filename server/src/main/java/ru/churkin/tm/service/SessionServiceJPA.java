package ru.churkin.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.churkin.tm.api.ISessionService;
import ru.churkin.tm.dto.UserDTO;
import ru.churkin.tm.entity.Session;
import ru.churkin.tm.entity.User;
import ru.churkin.tm.repository.SessionRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SessionServiceJPA implements ISessionService {

    @Inject
    private EntityManagerFactory entityManagerFactory;

    @Inject
    private SessionRepository sessionRepository;

    @Override
    public Session createSession(@Nullable UserDTO user) {
        if (user == null) return null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        sessionRepository.setEntityManager(entityManager);
        /// создание сессии по юзеру
        Session session = new Session(user.getId());
        Integer sign = (user.getName() + user.getPassword()).hashCode();
        session.setSignature(sign.toString());

        entityManager.getTransaction().begin();
        sessionRepository.createSession(session);
        entityManager.getTransaction().commit();
        entityManager.close();
        return session;
    }

    @Override
    public Session getSessionById(@Nullable String id) {
        if (id == null) return null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        sessionRepository.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        Session session = sessionRepository.getSessionById(id);
        entityManager.close();
        return session;
    }

    //    @Override
//    public Session getSessionById(String id) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        sessionRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
//        Session sessionFromBase = sessionRepository.getById(id);
//        entityManager.close();
//        return sessionFromBase;
//    }


    @Override
    public Session getSessionByUserId(@Nullable String userId) {
        if (userId == null) return null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        sessionRepository.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        Session session = sessionRepository.getByUserId(userId);
        entityManager.close();
        return session;
    }

    @Override
    public void deleteSession(@Nullable Session session) {
        if (session == null) return;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        sessionRepository.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        sessionRepository.deleteSession(session);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public boolean validateSession(@Nullable Session session) {
        if (session == null) return false;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        sessionRepository.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        String id = session.getId();
        Session sessionInBase = getSessionById(id);
        if (!session.getSignature().equals(sessionInBase.getSignature())) {
            return false;
        }
        entityManager.close();
        return true;
    }


}
