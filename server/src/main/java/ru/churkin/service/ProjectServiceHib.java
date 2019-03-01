package ru.churkin.service;

import ru.churkin.api.ProjectService;
import ru.churkin.dto.Project;

import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.util.List;

public class ProjectServiceHib implements ProjectService {

    private EntityManagerFactory entityManagerFactory;

    public ProjectServiceHib(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public boolean createProject(Project project) throws SQLException {
        return false;
    }

    @Override
    public Project findProjectByName(String name) throws SQLException {
        return null;
    }

    @Override
    public boolean updateProject(String id, Project project) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteProject(String id) throws SQLException {
        return false;
    }

    @Override
    public List<Project> getProjectAll() throws SQLException {
        return null;
    }
}
