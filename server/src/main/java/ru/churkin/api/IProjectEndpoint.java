package ru.churkin.api;

import ru.churkin.entity.Project;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebService
public interface IProjectEndpoint {

    @WebMethod
    boolean createProject(@WebParam(name = "project") Project project) throws Exception;

    @WebMethod
    Project findProjectByName(@WebParam(name = "name") String name) throws Exception;

    @WebMethod
    boolean updateProject(@WebParam(name = "id") String id, @WebParam(name = "project") Project project) throws Exception;

    @WebMethod
    boolean deleteProject(@WebParam(name = "id") String id) throws Exception;

    @WebMethod
    List<Project> getAllProjects()throws Exception;
}
