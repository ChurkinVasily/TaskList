package ru.churkin.endpoint;

import ru.churkin.api.ITaskEndpoint;
import ru.churkin.api.ITaskRepository;
import ru.churkin.api.ServiceLocator;
import ru.churkin.entity.Task;

import javax.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebService
public class TaskEndpoint implements ITaskEndpoint {

    private ServiceLocator serviceLocator;

    public TaskEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public boolean createTask(Task task) throws SQLException {
        return serviceLocator.getTaskService().createTask(task);
    }

    @Override
    public Task findTaskByName(String name) throws SQLException {
        return serviceLocator.getTaskService().findTaskByName(name);
    }

    @Override
    public List<Task> findTaskByUserId(String id) throws SQLException {
        return serviceLocator.getTaskService().findTaskByUserId(id);
    }

    @Override
    public boolean updateTask(String id, Task task) throws SQLException {
        return serviceLocator.getTaskService().updateTask(id, task);
    }

    @Override
    public boolean deleteTask(String id) throws SQLException {
        return serviceLocator.getTaskService().deleteTask(id);
    }

    @Override
    public Map<String, Task> getAllTasks() throws SQLException {
        return serviceLocator.getTaskService().getAllTasks();
    }
}
