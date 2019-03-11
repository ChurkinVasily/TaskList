package ru.churkin.tm.repository;

import ru.churkin.tm.api.IConnInit;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class ConnectionInitializer implements IConnInit {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TASKList");

    public static EntityManagerFactory getEntityManagerFactory() {
//        return entityManagerFactory;
        return Persistence.createEntityManagerFactory("TASKList");
    }

    public EntityManager getEntityManager() {
     return entityManagerFactory.createEntityManager();
    }


}
