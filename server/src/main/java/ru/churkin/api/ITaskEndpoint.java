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
    boolean createTask(@WebParam Task task) throws SQLException;

    @WebMethod
    Task findTaskByName(@WebParam String name) throws SQLException;

    @WebMethod
    List<Task> findTaskByUserId(@WebParam String id) throws SQLException;

    @WebMethod
    boolean updateTask(@WebParam String id, @WebParam Task task) throws SQLException;

    @WebMethod
    boolean deleteTask(@WebParam String id) throws SQLException;

    @WebMethod
    Map<String, Task> getAllTasks() throws SQLException;
}
