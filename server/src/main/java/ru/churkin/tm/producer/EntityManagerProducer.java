package ru.churkin.tm.producer;

import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;
import org.apache.deltaspike.jpa.api.transaction.TransactionScoped;
import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@ApplicationScoped
public class EntityManagerProducer {


//    private EntityManagerFactory emf;
//
//    @PostConstruct
//    private void init() {
//        emf = Persistence.createEntityManagerFactory("TASKList");
//    }


    @Inject
    @PersistenceUnitName("TASKList")
    private EntityManagerFactory emf;   // = Persistence.createEntityManagerFactory("TASKList");

    @NotNull
    @Produces
    @TransactionScoped
    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public void dispose(@Disposes EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}