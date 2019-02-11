package ru.churkin.api;

import ru.churkin.entity.Task;

public interface TaskService {

    boolean createTask(Task task);

    Task findTaskByName(String name);

    boolean updateTask(String id, Task task);

    boolean deleteTask(String id);
}
