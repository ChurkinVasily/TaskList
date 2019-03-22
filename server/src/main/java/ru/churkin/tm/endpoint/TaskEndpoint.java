package ru.churkin.tm.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.churkin.tm.api.*;
import ru.churkin.tm.entity.Project;
import ru.churkin.tm.entity.Task;
import ru.churkin.tm.dto.TaskDTO;
import ru.churkin.tm.entity.User;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Component
@WebService
public class TaskEndpoint implements ITaskEndpoint {

//    @Inject
    @Autowired
    private TaskService taskService;
//    @Inject
    @Autowired
    private ProjectService projectService;
//    @Inject
    @Autowired
    private UserService userService;

    @Override
    public boolean createTask(@WebParam(name = "name") String name,
                              @WebParam(name = "projectId") String projectId,
                              @WebParam(name = "userId") String userId) throws Exception {
        Project project = projectService.findProjectById(projectId);
        User user = userService.findUserById(userId);
        return taskService.createTask(name, user, project);
    }

    @Override
    public TaskDTO findTaskByName(@WebParam(name = "name") String name) throws Exception {
        TaskDTO taskDTO = TaskDTO.toDTO(taskService.findTaskByName(name));
        return taskDTO;
    }

    @Override
    public List<TaskDTO> findTaskByUserId(@WebParam(name = "id") String id) throws Exception {
        List<Task> list = taskService.findTaskByUserId(id);
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
        Task task = taskService.findTaskByName(name);
        task.setName(newName);
        task.setDescription(description);
        task.setTimeStart(timeStart);
        task.setTimeFinish(timeFinish);
        task.setProject(projectService.findProjectById(projectId));
        task.setUser(userService.getCurrentUser());
        task.setUser(userService.findUserById(userId));
        return taskService.updateTask(name, task);
    }

    @Override
    public boolean deleteTask(@WebParam(name = "name") String name) throws Exception {
        return taskService.deleteTask(name);
    }

    @Override
    public List<TaskDTO> getAllTasks() throws Exception {
        List<Task> list = taskService.getTasksAll();
        return TaskDTO.toDTO(list);
    }
}