package ru.churkin.api;

import ru.churkin.entity.Task;

import java.util.List;
import java.util.Map;

public interface ITaskRepository {

    void createTask(Task task);

    Task findTaskByName(String name);

    List<Task> findTasksByUserId(String userId);

    void updateTask(Task task);

    void deleteTask(String id);

    Map<String, Task> getTaskMap();
}
