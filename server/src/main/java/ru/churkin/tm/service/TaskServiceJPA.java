package ru.churkin.tm.service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.Nullable;
import ru.churkin.tm.api.TaskService;
import ru.churkin.tm.entity.Project;
import ru.churkin.tm.entity.Task;
import ru.churkin.tm.entity.User;
import ru.churkin.tm.repository.TaskRepositoryDS;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Transactional
public class TaskServiceJPA implements TaskService {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private TaskRepositoryDS taskRepository;

    @Override
    public boolean createTask(@Nullable final String taskName,
                              @Nullable final User user,
                              @Nullable final Project project) {
        logger.info(" -------------------- create task start");
        if (taskName == null || user == null || project == null) return false;
        Task task = new Task(taskName, user, project);
        return createTask(task);
    }

    @Override
    public boolean createTask(Task task) {
        logger.info(" -------------------- create task start");
        final String id = UUID.randomUUID().toString();
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
        return true;
    }

    @Nullable
    @Override
    public Task findTaskByName(@Nullable final String name) {
        logger.info(" -------------------- find task by name start");
        if (name == null || name.isEmpty()) return null;
        Task task;
        boolean isConsist = false;
        for (Task cTask : taskRepository.findAll()) {
            if (name.equals(cTask.getName())) {
                isConsist = true;
            }
        }
        if (isConsist) {
            task = taskRepository.findTaskByName(name);
            logger.info(" -------------------- find task by name finish");
            return task;
        } else return null;
    }

    @Override
    public List<Task> findTaskByUserId(@Nullable final String userId) {
        logger.info(" -------------------- find task by User id start");
        if (userId == null || userId.isEmpty()) return null;
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
        logger.info(" -------------------- find task by User id finish");
        return tasks;
    }

    @Override
    public boolean updateTask(@Nullable final String name, Task task) {
        logger.info(" -------------------- update task  start");
        if (name == null || name.isEmpty()) return false;
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
        logger.info(" -------------------- update task finish");
        return true;
    }


    @Override
    public boolean deleteTask(@Nullable final String name) {
        logger.info(" -------------------- delete task  start");
        if (name == null || name.isEmpty()) return false;
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
        logger.info(" -------------------- get all tasks start");
        List<Task> listTask = taskRepository.findAll();
        logger.info(" -------------------- get all tasks finish");
        return listTask;
    }
}
