package ru.churkin.tm.repository;

import ru.churkin.tm.entity.Project;
import ru.churkin.tm.entity.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SessionRepository {

    EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createSession(Session session) {
        entityManager.persist(session);
    }

    public void deleteSession(Session session) {
        if (entityManager.contains(session)) {
            entityManager.remove(session);
        }
        Session tempSession = entityManager.getReference(Session.class, session.getId());
        entityManager.remove(tempSession);
    }

    public List<Session> getAllSession() {
        return entityManager.createQuery("select e from Session e", Session.class).getResultList();
    }

    public Session getSessionById(String id) {
        return entityManager.createQuery("select e from Session e where id = :sessionId", Session.class)
                .setParameter("sessionId", id)
                .getSingleResult();
    }

    public Session getByUserId(String userId) {
        return entityManager.createQuery("select e from Session e where userId = :userId", Session.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }


}
