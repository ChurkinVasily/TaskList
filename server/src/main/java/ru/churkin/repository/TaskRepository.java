package ru.churkin.repository;

import ru.churkin.api.ITaskRepository;
import ru.churkin.dto.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TaskRepository implements ITaskRepository {

    private EntityManager entityManager;

    public TaskRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createTask(Task task) throws SQLException {

    }

    @Override
    public Task findTaskByName(String name) throws SQLException {
        return null;
    }

    @Override
    public List<Task> findTasksByUserId(String userId) throws SQLException {
        return null;
    }

    @Override
    public void updateTask(Task task) throws SQLException {

    }

    @Override
    public void deleteTask(String id) throws SQLException {

    }

    @Override
    public Map<String, Task> getTaskMap() throws SQLException {
        return null;
    }
}
