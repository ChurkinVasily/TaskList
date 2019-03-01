package ru.churkin.api;

import ru.churkin.dto.Task;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ITaskRepository {

    void createTask(Task task) throws SQLException;

    Task findTaskByName(String name) throws SQLException;

    List<Task> findTasksByUserId(String userId) throws SQLException;

    void updateTask(Task task) throws SQLException;

    void deleteTask(String id) throws SQLException;

    Map<String, Task> getTaskMap() throws SQLException;
}
