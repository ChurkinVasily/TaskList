package ru.churkin.endpoint;

import ru.churkin.api.ITaskEndpoint;
import ru.churkin.api.ServiceLocator;
import ru.churkin.entity.Task;
import ru.churkin.dto2.TaskDTO;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class TaskEndpoint implements ITaskEndpoint {

    private ServiceLocator serviceLocator;

    public TaskEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public boolean createTask(@WebParam(name = "name") String name) throws Exception {
        return serviceLocator.getTaskService().createTask(name);
    }

    @Override
    public TaskDTO findTaskByName(@WebParam(name = "name") String name) throws Exception {
        TaskDTO taskDTO = TaskDTO.toDTO(serviceLocator.getTaskService().findTaskByName(name));
        return taskDTO;
    }

    @Override
    public List<TaskDTO> findTaskByUserId(@WebParam(name = "id") String id) throws Exception {
        List<Task> list = serviceLocator.getTaskService().findTaskByUserId(id);
        return TaskDTO.toDTO(list);
    }

    @Override
    public boolean updateTask(@WebParam(name = "name")String name,
                              @WebParam(name = "newName") String newName,
                              @WebParam(name = "description") String description,
                              @WebParam(name = "timeStart") String timeStart,
                              @WebParam(name = "tineFinish") String timeFinish,
                              @WebParam(name = "projectID") String projectId,
                              @WebParam(name = "userID") String userId
                              ) throws Exception {
        Task task = serviceLocator.getTaskService().findTaskByName(name);
        task.setName(newName);
        task.setDescription(description);
        task.setTimeStart(timeStart);
        task.setTimeFinish(timeFinish);
        task.setProject(serviceLocator.getProjectService().findProjectById(projectId));
        task.setUser(serviceLocator.getUserService().findUserById(userId));
        return serviceLocator.getTaskService().updateTask(name, task);
    }

    @Override
    public boolean deleteTask(@WebParam(name = "id") String id) throws Exception {
        return serviceLocator.getTaskService().deleteTask(id);
    }

    @Override
    public List<TaskDTO> getAllTasks() throws Exception {
        List<Task> list = serviceLocator.getTaskService().getTasksAll();
        return TaskDTO.toDTO(list);
    }
}