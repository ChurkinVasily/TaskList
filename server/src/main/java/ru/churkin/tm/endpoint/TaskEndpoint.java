package ru.churkin.tm.endpoint;

import ru.churkin.tm.api.ITaskEndpoint;
import ru.churkin.tm.api.ServiceLocator;
import ru.churkin.tm.entity.Project;
import ru.churkin.tm.entity.Task;
import ru.churkin.tm.dto.TaskDTO;
import ru.churkin.tm.entity.User;

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
    public boolean createTask(@WebParam(name = "name") String name,
                              @WebParam(name = "projectId") String projectId) throws Exception {
        Project project = serviceLocator.getProjectService().findProjectById(projectId);
        User user = serviceLocator.getUserService().getCurrentUser();
        return serviceLocator.getTaskService().createTask(name, user, project);
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
                              @WebParam(name = "projectID") String projectId
//                              @WebParam(name = "userID") String userId
                              ) throws Exception {
        Task task = serviceLocator.getTaskService().findTaskByName(name);
        task.setName(newName);
        task.setDescription(description);
        task.setTimeStart(timeStart);
        task.setTimeFinish(timeFinish);
        task.setProject(serviceLocator.getProjectService().findProjectById(projectId));
        task.setUser(serviceLocator.getUserService().getCurrentUser());
//        task.setUser(serviceLocator.getUserService().findUserById(userId));
        return serviceLocator.getTaskService().updateTask(name, task);
    }

    @Override
    public boolean deleteTask(@WebParam(name = "name") String name) throws Exception {
        return serviceLocator.getTaskService().deleteTask(name);
    }

    @Override
    public List<TaskDTO> getAllTasks() throws Exception {
        List<Task> list = serviceLocator.getTaskService().getTasksAll();
        return TaskDTO.toDTO(list);
    }
}