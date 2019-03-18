package ru.churkin.tm.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.churkin.tm.entity.Session;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@Repository
public interface SessionRepositoryDS extends FullEntityRepository<Session, String> {


//    --- унаслелован от родителя. persist
//    void createSession(Session session);
@Inject
void setEntityManager(EntityManager entityManager);

//    public void deleteSession(Session session) {
//        if (entityManager.contains(session)) {
//            entityManager.remove(session);
//        }
//        Session tempSession = entityManager.getReference(Session.class, session.getId());
//        entityManager.remove(tempSession);
//    }

//    --- унаследован от родителя
//    List<Session> getAllSession();

    @NotNull
    @Query("select e from Session e where id = :sessionId")
    Session getSessionById(@QueryParam("sessionId") String id);

    @NotNull
    @Query("select e from Session e where userId = :userId")
    Session getByUserId(@QueryParam("userId") String userId);

}
