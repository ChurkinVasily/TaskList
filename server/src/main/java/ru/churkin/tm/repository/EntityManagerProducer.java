package ru.churkin.tm.repository;

import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;
import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.TransactionScoped;

@ApplicationScoped
public class EntityManagerProducer {

//    @ApplicationScoped
//    @Produces
//    public static EntityManagerFactory entityManagerFactory() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TASKList");
//        return emf;
//    }

//   @PersistenceUnit(unitName = "TASKList")
    @PersistenceContext(unitName = "TASKList")
    private EntityManagerFactory entityManagerFactory;

    @NotNull
    @Produces
    @TransactionScoped
    public EntityManager create(){
        return entityManagerFactory.createEntityManager();
    }

    public void dispose(@Disposes EntityManager entityManager) {
        if (entityManager.isOpen())
        {
            entityManager.close();
        }
    }

}
