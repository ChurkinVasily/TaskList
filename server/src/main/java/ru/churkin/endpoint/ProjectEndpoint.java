package ru.churkin.endpoint;

import ru.churkin.api.IProjectEndpoint;
import ru.churkin.api.ServiceLocator;
import ru.churkin.entity.Project;

import javax.jws.WebService;
import java.sql.SQLException;
import java.util.Map;

@WebService
public class ProjectEndpoint implements IProjectEndpoint {

    private ServiceLocator serviceLocator;

    public ProjectEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public boolean createProject(Project project) throws SQLException {
        return serviceLocator.getProjectService().createProject(project);
    }

    @Override
    public Project findProjectByName(String name) throws SQLException {
        return serviceLocator.getProjectService().findProjectByName(name);
    }

    @Override
    public boolean updateProject(String id, Project project) throws SQLException {
        return serviceLocator.getProjectService().updateProject(id, project);
    }

    @Override
    public boolean deleteProject(String id) throws SQLException {
        return serviceLocator.getProjectService().deleteProject(id);
    }

    @Override
    public Map<String, Project> getAllProjects() throws SQLException {
        return serviceLocator.getProjectService().getProjectAll();
    }
}