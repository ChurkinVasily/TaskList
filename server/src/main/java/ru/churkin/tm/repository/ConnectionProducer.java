package ru.churkin.tm.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionProducer {

    @ApplicationScoped
    @Produces
    public static EntityManagerFactory entityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TASKList");
        return emf;
    }



}
