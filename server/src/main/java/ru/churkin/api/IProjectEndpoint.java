package ru.churkin.api;

import ru.churkin.entity.Project;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.Map;

@WebService
public interface IProjectEndpoint {

    @WebMethod
    boolean createProject(@WebParam Project project) throws SQLException;

    @WebMethod
    Project findProjectByName(@WebParam String name) throws SQLException;

    @WebMethod
    boolean updateProject(@WebParam String id, @WebParam Project project) throws SQLException;

    @WebMethod
    boolean deleteProject(@WebParam String id) throws SQLException;

    @WebMethod
    Map<String, Project> getAllProjects() throws SQLException;
}
