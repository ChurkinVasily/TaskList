package ru.churkin.api;

import ru.churkin.entity.Task;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ITaskRepository {

    Task createTask(Task task) throws SQLException;

    Task findTaskByName(String name) throws SQLException;

    List<Task> findTasksByUserId(String userId) throws SQLException;

    void updateTask(Task task) throws SQLException;

    void deleteTask(Task task) throws SQLException;

    List<Task> getTaskList() throws SQLException;
}
