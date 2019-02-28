package ru.churkin.endpoint;

import ru.churkin.api.ITaskEndpoint;
import ru.churkin.api.ServiceLocator;
import ru.churkin.entity.Task;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebService
public class TaskEndpoint implements ITaskEndpoint {

    private ServiceLocator serviceLocator;

    public TaskEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public boolean createTask(@WebParam(name = "task")Task task) throws SQLException {
        return serviceLocator.getTaskService().createTask(task);
    }

    @Override
    public Task findTaskByName(@WebParam(name = "name") String name) throws SQLException {
        return serviceLocator.getTaskService().findTaskByName(name);
    }

    @Override
    public List<Task> findTaskByUserId(@WebParam(name = "id") String id) throws SQLException {
        return serviceLocator.getTaskService().findTaskByUserId(id);
    }

    @Override
    public boolean updateTask(@WebParam(name = "id")String id, @WebParam(name = "task")Task task) throws SQLException {
        return serviceLocator.getTaskService().updateTask(id, task);
    }

    @Override
    public boolean deleteTask(@WebParam(name = "id") String id) throws SQLException {
        return serviceLocator.getTaskService().deleteTask(id);
    }

    @Override
    public List<Task> getAllTasks() throws Exception {
        return serviceLocator.getTaskService().getTasksAll();
    }
}