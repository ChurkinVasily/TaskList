package ru.churkin.tm.service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.churkin.tm.api.TaskService;
import ru.churkin.tm.entity.Project;
import ru.churkin.tm.entity.Task;
import ru.churkin.tm.entity.User;
import ru.churkin.tm.repository.TaskRepositoryDS;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
//@Transactional
public class TaskServiceJPA implements TaskService {

    @Inject
    private TaskRepositoryDS taskRepository;

//    @Inject
//    private EntityManagerFactory entityManagerFactory;

    @Override
    public boolean createTask(String taskName, User user, Project project) {
        Task task = new Task(taskName, user, project);
        return createTask(task);
    }

    @Override
    public boolean createTask(Task task) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        taskRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        String id = UUID.randomUUID().toString();
        task.setId(id);
        boolean isConsist = false;
        for (Task cTask : taskRepository.findAll()) {
            if (task.getName().equals(cTask.getName())) {
                isConsist = true;
            }
        }
        if (isConsist || task.getName().isEmpty()) {
            return false;
        }
        taskRepository.persist(task);
//        entityManager.getTransaction().commit();
//        entityManager.close();
        return true;

    }

    @Override
    public Task findTaskByName(String name) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        taskRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        Task task;
        boolean isConsist = false;
        for (Task cTask : taskRepository.findAll()) {
            if (name.equals(cTask.getName())) {
                isConsist = true;
            }
        }
        if (isConsist) {
            task = taskRepository.findTaskByName(name);
//            entityManager.close();
            return task;
        } else return null;
    }

    @Override
    public List<Task> findTaskByUserId(String userId) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        taskRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        List<Task> tasks;
        boolean isConsist = false;
        for (Task cTask : taskRepository.findAll()) {
            if (userId.equals(cTask.getUser().getId())) {
                isConsist = true;
            }
        }
        if (!isConsist) {
            return null;
        }
        tasks = taskRepository.findTasksByUserId(userId);
//        entityManager.close();
        return tasks;
    }

    @Override
    public boolean updateTask(String name, Task task) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        taskRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        boolean isConsist = false;
        String id = "";
        for (Task cTask : taskRepository.findAll()) {
            if (name.equals(cTask.getName())) {
                id = cTask.getId();
                task.setId(id);
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        }
        taskRepository.merge(task);
//        entityManager.getTransaction().commit();
//        entityManager.close();
        return true;
    }


    @Override
    public boolean deleteTask(String name) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        taskRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        boolean isConsist = false;
//        String idForRemove = "";
        for (Task ctask : taskRepository.findAll()) {
            if (name.equals(ctask.getName())) {
//                idForRemove = ctask.getId();
                isConsist = true;
            }
        }
        if (!isConsist || name.isEmpty()) {
            return false;
        }
        taskRepository.remove(taskRepository.findTaskByName(name));
//        entityManager.getTransaction().commit();
//        entityManager.close();
        return true;
    }

    @Override
    public List<Task> getTasksAll() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        taskRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        List<Task> listTask = taskRepository.findAll();
//        entityManager.close();
        return listTask;
    }
}
