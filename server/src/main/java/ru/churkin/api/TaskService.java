package ru.churkin.api;

import ru.churkin.entity.Task;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TaskService {

    boolean createTask(Task task) throws SQLException;

    Task findTaskByName(String name) throws SQLException;

    List<Task> findTaskByUserId(String id) throws SQLException;

    boolean updateTask(String id, Task task) throws SQLException;

    boolean deleteTask(String id) throws SQLException;

    Map<String, Task> getTasksAll() throws SQLException;
}
