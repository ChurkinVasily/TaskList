package ru.churkin.tm.repository;

import ru.churkin.tm.api.ITaskRepository;
import ru.churkin.tm.entity.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TaskRepository implements ITaskRepository {

    EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createTask(Task task) {
        entityManager.persist(task);
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
