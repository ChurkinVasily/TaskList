package ru.churkin.api;

import ru.churkin.entity.Task;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
    Map<String, Task> getAllTasks() throws Exception;
}
