package ru.churkin.repository;

import ru.churkin.api.ITaskRepository;
import ru.churkin.entity.Project;
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
    public Task createTask(Task task) {
        return entityManager.merge(task);
    }

    @Override
    public Task findTaskByName(String name) {
        return entityManager.createQuery("select t from Task t where t.name = :taskName", Task.class)
                .setParameter("taskName", name)
                .getSingleResult();
    }

    @Override
    public List<Task> findTasksByUserId(String userId) {
        return entityManager.createQuery("select t from Task t where t.user.id = :userId", Task.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public void updateTask(Task task) {
        entityManager.merge(task);
    }

    @Override
    public void deleteTask(Task task) {
        entityManager.remove(task);
    }

    @Override
    public List<Task> getTaskList() {
        return entityManager.createQuery("select e from Task e", Task.class).getResultList();
    }
}
