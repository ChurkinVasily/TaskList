package ru.churkin.api;


import ru.churkin.dto2.ProjectDTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;

@WebService
public interface IProjectEndpoint {

    @WebMethod
    boolean createProject(@WebParam(name = "projectName") String projectName) throws Exception;

    @WebMethod
    ProjectDTO findProjectByName(@WebParam(name = "name") String name) throws Exception;

    @WebMethod
    ProjectDTO findProjectById(@WebParam(name = "projectId") String projectId) throws Exception;

    @WebMethod
    boolean updateProject(@WebParam(name = "name") String name,
                          @WebParam(name = "newName") String newName,
                          @WebParam(name = "description") String description,
                          @WebParam(name = "timeStart") String timeStart,
                          @WebParam(name = "timeFinish") String timeFinish) throws Exception;

    @WebMethod
    boolean deleteProject(@WebParam(name = "id") String id) throws Exception;

    @WebMethod
    List<ProjectDTO> getAllProjects()throws Exception;
}
