package ru.churkin.tm.api;

import ru.churkin.tm.entity.Task;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public interface ITaskRepository {

    void setEntityManager(EntityManager entityManager);

    void createTask(Task task) throws SQLException;

    Task findTaskByName(String name) throws SQLException;

    List<Task> findTasksByUserId(String userId) throws SQLException;

    void updateTask(Task task) throws SQLException;

    void deleteTask(Task task) throws SQLException;

    List<Task> getTaskList() throws SQLException;
}
