package ru.churkin.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.churkin.tm.entity.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    @NotNull
    @Query("select t from Task t where t.name = :taskName")
    Task findTaskByName(@Param("taskName") String name);

    @NotNull
    @Query("select t from Task t where t.user.id = :userId")
    List<Task> findTasksByUserId(@Param("userId") String userId);

}
