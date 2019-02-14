package ru.churkin.api;

import ru.churkin.entity.Task;

import java.util.List;
import java.util.Map;

public interface TaskService {

    boolean createTask(Task task);

    Task findTaskByName(String name);

    List<Task> findTaskByUserId(String id);

    boolean updateTask(String id, Task task);

    boolean deleteTask(String id);

    Map<String, Task> getAllTasks();
}
