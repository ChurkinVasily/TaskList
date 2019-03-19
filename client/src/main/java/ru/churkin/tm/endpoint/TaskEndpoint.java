package ru.churkin.tm.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2019-03-19T18:32:07.011+03:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://endpoint.tm.churkin.ru/", name = "TaskEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface TaskEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/TaskEndpoint/updateTaskRequest", output = "http://endpoint.tm.churkin.ru/TaskEndpoint/updateTaskResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/TaskEndpoint/updateTask/Fault/Exception")})
    @RequestWrapper(localName = "updateTask", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.UpdateTask")
    @ResponseWrapper(localName = "updateTaskResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.UpdateTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean updateTask(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "newName", targetNamespace = "")
        java.lang.String newName,
        @WebParam(name = "description", targetNamespace = "")
        java.lang.String description,
        @WebParam(name = "timeStart", targetNamespace = "")
        java.lang.String timeStart,
        @WebParam(name = "tineFinish", targetNamespace = "")
        java.lang.String tineFinish,
        @WebParam(name = "projectID", targetNamespace = "")
        java.lang.String projectID
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/TaskEndpoint/getAllTasksRequest", output = "http://endpoint.tm.churkin.ru/TaskEndpoint/getAllTasksResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/TaskEndpoint/getAllTasks/Fault/Exception")})
    @RequestWrapper(localName = "getAllTasks", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.GetAllTasks")
    @ResponseWrapper(localName = "getAllTasksResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.GetAllTasksResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.churkin.tm.endpoint.TaskDTO> getAllTasks() throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/TaskEndpoint/findTaskByUserIdRequest", output = "http://endpoint.tm.churkin.ru/TaskEndpoint/findTaskByUserIdResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/TaskEndpoint/findTaskByUserId/Fault/Exception")})
    @RequestWrapper(localName = "findTaskByUserId", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.FindTaskByUserId")
    @ResponseWrapper(localName = "findTaskByUserIdResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.FindTaskByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.churkin.tm.endpoint.TaskDTO> findTaskByUserId(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/TaskEndpoint/findTaskByNameRequest", output = "http://endpoint.tm.churkin.ru/TaskEndpoint/findTaskByNameResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/TaskEndpoint/findTaskByName/Fault/Exception")})
    @RequestWrapper(localName = "findTaskByName", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.FindTaskByName")
    @ResponseWrapper(localName = "findTaskByNameResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.FindTaskByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.churkin.tm.endpoint.TaskDTO findTaskByName(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/TaskEndpoint/deleteTaskRequest", output = "http://endpoint.tm.churkin.ru/TaskEndpoint/deleteTaskResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/TaskEndpoint/deleteTask/Fault/Exception")})
    @RequestWrapper(localName = "deleteTask", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.DeleteTask")
    @ResponseWrapper(localName = "deleteTaskResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.DeleteTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean deleteTask(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/TaskEndpoint/createTaskRequest", output = "http://endpoint.tm.churkin.ru/TaskEndpoint/createTaskResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/TaskEndpoint/createTask/Fault/Exception")})
    @RequestWrapper(localName = "createTask", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.CreateTask")
    @ResponseWrapper(localName = "createTaskResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.CreateTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean createTask(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "projectId", targetNamespace = "")
        java.lang.String projectId,
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.String userId
    ) throws Exception_Exception;
}
