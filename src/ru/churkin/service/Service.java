package ru.churkin.service;

import ru.churkin.entity.Task;

public interface Service {

    void createTask(Task task);

    Task findTaskByName(String name);

    void updateTask(String id, Task task);

    void deleteTask(String id);
}
