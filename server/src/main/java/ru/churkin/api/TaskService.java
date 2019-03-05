package ru.churkin.api;

import ru.churkin.entity.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskService {

    boolean createTask(Task task) throws SQLException;

    boolean createTask(String name) throws SQLException;

    Task findTaskByName(String name) throws SQLException;

    List<Task> findTaskByUserId(String id) throws SQLException;

    boolean updateTask(String id, Task task) throws SQLException;

    boolean deleteTask(String name) throws SQLException;

    List<Task> getTasksAll() throws SQLException;
}
