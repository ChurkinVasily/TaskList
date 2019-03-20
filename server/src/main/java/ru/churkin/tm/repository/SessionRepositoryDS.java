package ru.churkin.tm.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.churkin.tm.entity.Session;

@Repository
public interface SessionRepositoryDS extends FullEntityRepository<Session, String> {

    @NotNull
    @Query("select e from Session e where id = :sessionId")
    Session getSessionById(@QueryParam("sessionId") String id);

    @NotNull
    @Query("select e from Session e where userId = :userId")
    Session getByUserId(@QueryParam("userId") String userId);

//    @Query("delete from Session e where id = :id")
//    void deleteSessionById(@QueryParam("id") String id);

//    --- унаслелован от родителя. persist

///////////// - ----- удаление сессиии методом remove не работает.
//    void createSession(Session session);
//    public void deleteSession(Session session) {
//        if (entityManager.contains(session)) {
//            entityManager.remove(session);
//        }
//        Session tempSession = entityManager.getReference(Session.class, session.getId());
//        entityManager.remove(tempSession);

//    }
//    --- унаследован от родителя
//    List<Session> getAllSession();

}
