package ru.churkin.api;

import ru.churkin.dto.Task;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ITaskEndpoint {

    @WebMethod
    boolean createTask(@WebParam(name = "task") Task task) throws Exception;

    @WebMethod
    Task findTaskByName(@WebParam(name = "name") String name) throws Exception;

    @WebMethod
    List<Task> findTaskByUserId(@WebParam(name = "id") String id) throws Exception;

    @WebMethod
    boolean updateTask(@WebParam(name = "id") String id, @WebParam(name = "task") Task task) throws Exception;

    @WebMethod
    boolean deleteTask(@WebParam String id) throws Exception;

    @WebMethod
    List<Task> getAllTasks() throws Exception;
}
