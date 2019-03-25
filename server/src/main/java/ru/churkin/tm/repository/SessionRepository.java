package ru.churkin.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.churkin.tm.entity.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {

    @NotNull
    @Query("select e from Session e where id = :sessionId")
    Session getSessionById(@Param("sessionId") String id);

    @NotNull
    @Query("select e from Session e where userId = :userId")
    Session getByUserId(@Param("userId") String userId);

}
