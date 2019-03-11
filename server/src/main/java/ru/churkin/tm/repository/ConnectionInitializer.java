package ru.churkin.tm.repository;

import ru.churkin.tm.api.IConnInit;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class ConnectionInitializer {  ///implements IConnInit {

    @ApplicationScoped
    @Produces
    public static EntityManagerFactory entityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TASKList");
        return emf;
    }



}
