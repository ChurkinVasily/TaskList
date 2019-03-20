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
 * 2019-03-20T19:19:33.069+03:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://endpoint.tm.churkin.ru/", name = "ProjectEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface ProjectEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/ProjectEndpoint/findProjectByNameRequest", output = "http://endpoint.tm.churkin.ru/ProjectEndpoint/findProjectByNameResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/ProjectEndpoint/findProjectByName/Fault/Exception")})
    @RequestWrapper(localName = "findProjectByName", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.FindProjectByName")
    @ResponseWrapper(localName = "findProjectByNameResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.FindProjectByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.churkin.tm.endpoint.ProjectDTO findProjectByName(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/ProjectEndpoint/findProjectByIdRequest", output = "http://endpoint.tm.churkin.ru/ProjectEndpoint/findProjectByIdResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/ProjectEndpoint/findProjectById/Fault/Exception")})
    @RequestWrapper(localName = "findProjectById", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.FindProjectById")
    @ResponseWrapper(localName = "findProjectByIdResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.FindProjectByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.churkin.tm.endpoint.ProjectDTO findProjectById(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/ProjectEndpoint/deleteProjectRequest", output = "http://endpoint.tm.churkin.ru/ProjectEndpoint/deleteProjectResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/ProjectEndpoint/deleteProject/Fault/Exception")})
    @RequestWrapper(localName = "deleteProject", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.DeleteProject")
    @ResponseWrapper(localName = "deleteProjectResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.DeleteProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean deleteProject(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/ProjectEndpoint/updateProjectRequest", output = "http://endpoint.tm.churkin.ru/ProjectEndpoint/updateProjectResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/ProjectEndpoint/updateProject/Fault/Exception")})
    @RequestWrapper(localName = "updateProject", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.UpdateProject")
    @ResponseWrapper(localName = "updateProjectResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.UpdateProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean updateProject(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "newName", targetNamespace = "")
        java.lang.String newName,
        @WebParam(name = "description", targetNamespace = "")
        java.lang.String description,
        @WebParam(name = "timeStart", targetNamespace = "")
        java.lang.String timeStart,
        @WebParam(name = "timeFinish", targetNamespace = "")
        java.lang.String timeFinish
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/ProjectEndpoint/getAllProjectsRequest", output = "http://endpoint.tm.churkin.ru/ProjectEndpoint/getAllProjectsResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/ProjectEndpoint/getAllProjects/Fault/Exception")})
    @RequestWrapper(localName = "getAllProjects", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.GetAllProjects")
    @ResponseWrapper(localName = "getAllProjectsResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.GetAllProjectsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.churkin.tm.endpoint.ProjectDTO> getAllProjects() throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/ProjectEndpoint/createProjectRequest", output = "http://endpoint.tm.churkin.ru/ProjectEndpoint/createProjectResponse")
    @RequestWrapper(localName = "createProject", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.CreateProject")
    @ResponseWrapper(localName = "createProjectResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.CreateProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean createProject(
        @WebParam(name = "projectName", targetNamespace = "")
        java.lang.String projectName
    );
}
