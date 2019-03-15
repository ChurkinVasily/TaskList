package ru.churkin.tm.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.churkin.tm.entity.Task;

import java.util.List;

@Repository
public interface TaskRepositoryDS extends FullEntityRepository<Task, String> {

// ---- не нужен
//    void setEntityManager(EntityManager entityManager);

//    --- унаследован от родителя. persist метод
//    void createTask(Task task) throws SQLException;


    @NotNull
    @Query("select t from Task t where t.name = :taskName")
    Task findTaskByName(@QueryParam("taskName") String name);

    @NotNull
    @Query("select t from Task t where t.user.id = :userId")
    List<Task> findTasksByUserId(@QueryParam("userId") String userId);

//    ---- унаследован от родителя. merge метод
//    void updateTask(Task task) throws SQLException;

//    ---- унаследован от родителя. remove метод
//    void deleteTask(Task task) throws SQLException;

//    ---- унаследован от родителя. findAll метод
//    List<Task> getTaskList() throws SQLException;

}
