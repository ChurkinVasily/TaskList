package ru.churkin.endpoint;

import ru.churkin.api.IProjectEndpoint;
import ru.churkin.api.ServiceLocator;
import ru.churkin.entity.Project;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebService
public class ProjectEndpoint implements IProjectEndpoint {

    private ServiceLocator serviceLocator;

    public ProjectEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public boolean createProject(@WebParam(name = "project") Project project) throws Exception {
        return serviceLocator.getProjectService().createProject(project);
    }

    @Override
    public Project findProjectByName(@WebParam(name = "name") String name) throws Exception {
        return serviceLocator.getProjectService().findProjectByName(name);
    }

    @Override
    public boolean updateProject(@WebParam(name = "id") String id, @WebParam(name = "project") Project project) throws Exception {
        return serviceLocator.getProjectService().updateProject(id, project);
    }

    @Override
    public boolean deleteProject(@WebParam(name = "id")String id) throws Exception {
        return serviceLocator.getProjectService().deleteProject(id);
    }

    @Override
    public List<Project> getAllProjects() throws Exception {
        return serviceLocator.getProjectService().getProjectAll();
    }
}