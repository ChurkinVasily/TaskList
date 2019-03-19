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
import java.util.logging.Logger;

//@ApplicationScoped
@Transactional
public class TaskServiceJPA implements TaskService {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private TaskRepositoryDS taskRepository;

//    @Inject
//    private EntityManagerFactory entityManagerFactory;

    @Override
    public boolean createTask(String taskName, User user, Project project) {
        logger.info(" -------------------- create task start");
        Task task = new Task(taskName, user, project);
        return createTask(task);
    }

    @Override
    public boolean createTask(Task task) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        taskRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        logger.info(" -------------------- create task start");
        String id = UUID.randomUUID().toString();
        task.setId(id);
        boolean isConsist = false;
        for (Task cTask : taskRepository.findAll()) {
            if (task.getName().equals(cTask.getName())) {
                isConsist = true;
            }
        }
        if (isConsist || task.getName().isEmpty()) {
            logger.info(" -------------------- create task false");
            return false;
        }
        taskRepository.persist(task);
        logger.info(" -------------------- create task true");
//        entityManager.getTransaction().commit();
//        entityManager.close();
        return true;

    }

    @Override
    public Task findTaskByName(String name) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        taskRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        logger.info(" -------------------- find task by name start");
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
            logger.info(" -------------------- find task by name finish");
            return task;
        } else return null;
    }

    @Override
    public List<Task> findTaskByUserId(String userId) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        taskRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        logger.info(" -------------------- find task by User id start");
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
        logger.info(" -------------------- find task by User id finish");
        return tasks;
    }

    @Override
    public boolean updateTask(String name, Task task) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        taskRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        logger.info(" -------------------- update task  start");
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
        logger.info(" -------------------- update task finish");
        return true;
    }


    @Override
    public boolean deleteTask(String name) {
        logger.info(" -------------------- delete task  start");
        boolean isConsist = false;
        for (Task ctask : taskRepository.findAll()) {
            if (name.equals(ctask.getName())) {
                isConsist = true;
                logger.info(" -------------------- delete task : is consist");
            }
        }
        if (!isConsist || name.isEmpty()) {
            logger.info(" -------------------- delete task : is consist == false");
            return false;
        }
        taskRepository.remove(taskRepository.findTaskByName(name));
        logger.info(" -------------------- delete task  finish");
        return true;
    }

    @Override
    public List<Task> getTasksAll() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        taskRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        logger.info(" -------------------- get all tasks start");
        List<Task> listTask = taskRepository.findAll();
//        entityManager.close();
        logger.info(" -------------------- get all tasks finish");
        return listTask;
    }
}
