package ru.churkin.service;

import ru.churkin.api.TaskService;
import ru.churkin.dto.Task;
import ru.churkin.repository.TaskRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TaskServiceHib implements TaskService {

    private EntityManagerFactory entityManagerFactory;

    public TaskServiceHib(EntityManagerFactory emf) {
        this.entityManagerFactory = emf;
    }

    @Override
    public boolean createTask(Task task) throws SQLException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TaskRepository taskRepository = new TaskRepository(entityManager);
        String id = UUID.randomUUID().toString();
        task.setId(id);
        String taskName = task.getName();
        boolean isConsist = false;
        for (Map.Entry<String, Task> entry : taskRepository.getTaskMap().entrySet()) {
            if (taskName.equals(entry.getValue().getName())) {
                isConsist = true;
            }
        }
        if (isConsist || task.getName().equals("")) {
            return false;
        } else {
            /// создание таска в базе
            entityManager.getTransaction().begin();
            taskRepository.createTask(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
    }

    @Override
    public Task findTaskByName(String name) throws SQLException {
        return null;
    }

    @Override
    public List<Task> findTaskByUserId(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean updateTask(String id, Task task) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteTask(String id) throws SQLException {
        return false;
    }

    @Override
    public List<Task> getTasksAll() throws SQLException {
        return null;
    }
}
