package ru.churkin.repository;

import ru.churkin.api.IProjectRepository;
import ru.churkin.dto.Project;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.Map;

public class ProjectRepository implements IProjectRepository {

    private EntityManager entityManager;

    public ProjectRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createProject(Project project) throws SQLException {

    }

    @Override
    public Project findProjectByName(String name) throws SQLException {
        return null;
    }

    @Override
    public void updateProject(Project project) throws SQLException {

    }

    @Override
    public void deleteProject(String id) throws SQLException {

    }

    @Override
    public Map<String, Project> getProjectMap() throws SQLException {
        return null;
    }
}
