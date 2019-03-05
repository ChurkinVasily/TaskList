package ru.churkin.service;

import ru.churkin.api.TaskService;
import ru.churkin.entity.Project;
import ru.churkin.entity.Task;
import ru.churkin.repository.TaskRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TaskServiceHib implements TaskService {

    private EntityManagerFactory entityManagerFactory;

    public TaskServiceHib(EntityManagerFactory emf) {
        this.entityManagerFactory = emf;
    }

    @Override
    public boolean createTask(String taskName) {
        Task task = new Task(taskName);
        return createTask(task);
    }

    @Override
    public boolean createTask(Task task) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TaskRepository taskRepository = new TaskRepository(entityManager);
        entityManager.getTransaction().begin();
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
            taskRepository.createTask(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
    }

    @Override
    public Task findTaskByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TaskRepository taskRepository = new TaskRepository(entityManager);
        entityManager.getTransaction().begin();
//        String currentId = null;
        Task task;
        boolean isConsist = false;
        for (Map.Entry<String, Task> entry : taskRepository.getTaskMap().entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                isConsist = true;
//                currentId = nTask.getId();
            }
        }
        if (isConsist) {
            task = taskRepository.findTaskByName(name);
//            task = entityManager.find(Task.class, currentId);
            entityManager.close();
            return task;
        } else return null;
    }

    @Override
    public List<Task> findTaskByUserId(String userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TaskRepository taskRepository = new TaskRepository(entityManager);
        entityManager.getTransaction().begin();
        List<Task> tasks;
        boolean isConsist = false;
        for (Map.Entry<String, Task> entry : taskRepository.getTaskMap().entrySet()) {
            if (userId.equals(entry.getValue().getUserId())) {
                isConsist = true;
            }
        }
        if (isConsist) {
            tasks = taskRepository.findTasksByUserId(userId);
            entityManager.close();
            return tasks;
        } else return null;
    }

    @Override
    public boolean updateTask(String name, Task task) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TaskRepository taskRepository = new TaskRepository(entityManager);
        entityManager.getTransaction().begin();
        boolean isConsist = false;
        String id = "";
        for (Map.Entry<String, Task> entry : taskRepository.getTaskMap().entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                id = entry.getValue().getId();
                task.setId(id);
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        } else {
            taskRepository.updateTask(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
    }

    @Override
    public boolean deleteTask(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TaskRepository taskRepository = new TaskRepository(entityManager);
        entityManager.getTransaction().begin();
        boolean isConsist = false;
        String idForRemove = "";
        for (Map.Entry<String, Task> entry : taskRepository.getTaskMap().entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                idForRemove = entry.getValue().getId();
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        } else {
            taskRepository.deleteTask(idForRemove);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
    }

    @Override
    public List<Task> getTasksAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TaskRepository taskRepository = new TaskRepository(entityManager);
        entityManager.getTransaction().begin();
        List<Task> listTask = new ArrayList<>();
        Map<String, Task> mapTask = taskRepository.getTaskMap();
        if (!mapTask.isEmpty()) {
            for (Map.Entry<String, Task> entry : mapTask.entrySet()) {
                Task task = entry.getValue();
                listTask.add(task);
            }
        }
        entityManager.close();
        return listTask;
    }
}
