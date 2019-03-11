package ru.churkin.tm.api;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface IConnInit {

    static EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("TASKList");
    }
}
