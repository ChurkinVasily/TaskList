package ru.churkin.tm.repository;

import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.TransactionScoped;

@ApplicationScoped
public class EntityManagerProducer {

//    @ApplicationScoped
//    @Produces
//    public static EntityManagerFactory entityManagerFactory() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TASKList");
//        return emf;
//    }

    @PersistenceUnit(unitName = "TASKList")
    private EntityManagerFactory entityManagerFactory;

    @NotNull
    @Produces
    @TransactionScoped
    public EntityManager createEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    public void dispose(@Disposes EntityManager entityManager) {
        if (entityManager.isOpen())
        {
            entityManager.close();
        }
    }

}
