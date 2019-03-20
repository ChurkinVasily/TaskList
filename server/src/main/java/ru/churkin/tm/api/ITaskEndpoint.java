package ru.churkin.tm.api;

import ru.churkin.tm.dto.TaskDTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ITaskEndpoint {

    @WebMethod
    boolean createTask(@WebParam(name = "name") String name,
                       @WebParam(name = "projectId") String projectId,
                       @WebParam(name = "userId") String userId) throws Exception;

    @WebMethod
    TaskDTO findTaskByName(@WebParam(name = "name") String name) throws Exception;

    @WebMethod
    List<TaskDTO> findTaskByUserId(@WebParam(name = "id") String id) throws Exception;

//    boolean updateTask(@WebParam(name = "id") String id, @WebParam(name = "task") Task task) throws Exception;

    @WebMethod
    boolean updateTask(@WebParam(name = "name") String name,
                       @WebParam(name = "newName") String newName,
                       @WebParam(name = "description") String description,
                       @WebParam(name = "timeStart") String timeStart,
                       @WebParam(name = "tineFinish") String timeFinish,
                       @WebParam(name = "projectID") String projectId,
                       @WebParam(name = "userID") String userId
    ) throws Exception;

    @WebMethod
    boolean deleteTask(@WebParam String id) throws Exception;

    @WebMethod
    List<TaskDTO> getAllTasks() throws Exception;
}
