package ru.churkin.api;

import ru.churkin.entity.Task;

import java.util.Map;

public interface TaskService {

    boolean createTask(Task task);

    Task findTaskByName(String name);

    boolean updateTask(String id, Task task);

    boolean deleteTask(String id);

    Map<String, Task> getAllTasks();
}
