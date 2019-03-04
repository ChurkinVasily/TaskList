package ru.churkin.repository;

import ru.churkin.api.ITaskRepository;
import ru.churkin.entity.Task;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

public class TaskRepository implements ITaskRepository {

    private EntityManager entityManager;

    public TaskRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createTask(Task task)  {

    }

    @Override
    public Task findTaskByName(String name)  {
        return null;
    }

    @Override
    public List<Task> findTasksByUserId(String userId)  {
        return null;
    }

    @Override
    public void updateTask(Task task)  {

    }

    @Override
    public void deleteTask(String id) {

    }

    @Override
    public Map<String, Task> getTaskMap() {
        return null;
    }
}
